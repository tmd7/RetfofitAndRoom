package com.tmarat.retfofitandroom.model.network;

import com.tmarat.retfofitandroom.common.Contract;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyRetrofit {

  private static final String API = "be4254a9c1592f329d3b479b522e69c3";
  private static final String BASE_URL = "http://api.openweathermap.org/";

  private Contract.OpenWeather openWeather;

  public MyRetrofit(String cityName) {
    initRetrofit();
    requestRetrofit(cityName);
  }

  private void initRetrofit() {
    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build();

    openWeather = retrofit.create(Contract.OpenWeather.class);
  }

  private void requestRetrofit(String cityName) {
    openWeather.loadWeather(cityName, API).enqueue(new Callback<WeatherRequest>() {
      @Override
      public void onResponse(Call<WeatherRequest> call, Response<WeatherRequest> response) {
        if (response.body() !=null) {
          // TODO: 03.07.2018 to add response in LiveData
        } else {
          // TODO: 03.07.2018 callBack to presenter
        }
      }

      @Override public void onFailure(Call<WeatherRequest> call, Throwable t) {
        // TODO: 03.07.2018 CallBack to presenter
      }
    });
  }
}
