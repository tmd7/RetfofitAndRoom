package com.tmarat.retfofitandroom.model;

import android.util.Log;
import com.tmarat.retfofitandroom.common.CallBack;
import com.tmarat.retfofitandroom.common.Contract;
import com.tmarat.retfofitandroom.model.network.MyRetrofit;
import com.tmarat.retfofitandroom.model.network.jsonpojo.WeatherRequest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Model implements Contract.Model {

  private static final String TAG = Model.class.getSimpleName();
  private static final String NO_DATA = "no data";
  private  WeatherInfoPojo weatherInfo;

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
    weatherInfo = new WeatherInfoPojo();

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
}
