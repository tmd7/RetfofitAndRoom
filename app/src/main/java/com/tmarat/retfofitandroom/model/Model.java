package com.tmarat.retfofitandroom.model;

import android.util.Log;
import com.tmarat.retfofitandroom.App;
import com.tmarat.retfofitandroom.common.CallBack;
import com.tmarat.retfofitandroom.common.Contract;
import com.tmarat.retfofitandroom.common.pojo.WeatherInfo;
import com.tmarat.retfofitandroom.common.pojo.WeatherRequest;
import com.tmarat.retfofitandroom.model.database.WeatherDao;
import com.tmarat.retfofitandroom.model.database.WeatherDataBase;
import com.tmarat.retfofitandroom.model.database.WeatherEntity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Model implements Contract.Model {

  private static final String TAG = Model.class.getSimpleName();
  private static final String NO_DATA = "no data";
  private WeatherInfo weatherInfo;

  private WeatherDataBase db;
  private WeatherDao weatherDao;

  public WeatherInfo getWeatherInfo() {
    return weatherInfo;
  }

  @Override public void cityNameIsOk(String cityName,
      CallBack.Response callBackResponse,
      CallBack.ResponseIsOk responseIsOk) {

    //cityName is Ok, does a retrofit request
    doRetrofitRequest(cityName, callBackResponse, responseIsOk);
  }

  private void doRetrofitRequest(String cityName, final CallBack.Response callBackResponse,
      final CallBack.ResponseIsOk responseIsOk) {
    Log.d(TAG, "doRetrofitRequest: Start");

    //Uses a retrofit fabric method which returns Call<WeatherRequest>. Does async request
    MyRetrofit.initRetrofit(cityName).enqueue(new Callback<WeatherRequest>() {
      @Override
      public void onResponse(Call<WeatherRequest> call, Response<WeatherRequest> response) {

        if (response.body() == null) {
          Log.d(TAG, "onResponse: body == null");
          callBackResponse.failure();
        } else {
          Log.d(TAG, "onResponse: body != null");
          checkAndWrapResponse(response);
          responseIsOk.getWeather(weatherInfo);

          //inserts weather data to db
          insertWeatherIntoDb(response);
        }
      }

      @Override public void onFailure(Call<WeatherRequest> call, Throwable t) {
        callBackResponse.failure();
        Log.d(TAG, "onFailure");
      }
    });
  }

  private void checkAndWrapResponse(Response<WeatherRequest> response) {
    Log.d(TAG, "postResponseIntoLiveData");

    //Adds some weather data to a pojo class from response.body
    weatherInfo = new WeatherInfo();

    if (response.body().getName() != null) {
      weatherInfo.setCityName(response.body().getName());
    } else {
      weatherInfo.setCityName(NO_DATA);
    }
    if (response.body().getMain().getTemp() != null) {
      weatherInfo.setTem(String.valueOf(response.body().getMain().getTemp()));
    } else {
      weatherInfo.setTem(NO_DATA);
    }
    if (response.body().getMain().getHumidity() != null) {
      weatherInfo.setHum(String.valueOf(response.body().getMain().getHumidity()));
    } else {
      weatherInfo.setHum(NO_DATA);
    }
    if (response.body().getMain().getPressure() != null) {
      weatherInfo.setPress(String.valueOf(response.body().getMain().getPressure()));
    } else {
      weatherInfo.setPress(NO_DATA);
    }
  }

  private void insertWeatherIntoDb(Response<WeatherRequest> response) {
    db = App.getInstance().getDataBase();
    weatherDao = db.weatherDao();
    final WeatherEntity weather = new WeatherEntity();
    weather.setCityName(response.body().getName());
    weather.setTem(response.body().getMain().getTemp());
    weather.setHum(response.body().getMain().getHumidity());
    weather.setPress(response.body().getMain().getPressure());

    new Thread(new Runnable() {
      @Override public void run() {
        weatherDao.insert(weather);
      }
    }).start();
  }
}
