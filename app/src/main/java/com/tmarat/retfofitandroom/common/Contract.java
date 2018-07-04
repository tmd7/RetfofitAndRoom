package com.tmarat.retfofitandroom.common;

import com.tmarat.retfofitandroom.common.pojo.WeatherInfo;
import com.tmarat.retfofitandroom.common.pojo.WeatherRequest;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Contract {

  interface View {
    void setWeather(WeatherInfo weather);

    void showToast(int resId);
  }

  interface Presenter {

    void getUserInput(String cityName);
  }

  interface Model {

    void cityNameIsOk(String cityName, CallBack.Response response,
        CallBack.ResponseIsOk responseIsOk);

  }

  interface OpenWeather {
    @GET("data/2.5/weather")
    Call<WeatherRequest> loadWeather(
        @Query("q") String cityName,
        @Query("appid") String keyApi);
  }
}
