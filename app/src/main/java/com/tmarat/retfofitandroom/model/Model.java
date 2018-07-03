package com.tmarat.retfofitandroom.model;

import com.tmarat.retfofitandroom.common.CallBack;
import com.tmarat.retfofitandroom.common.Contract;
import com.tmarat.retfofitandroom.model.network.MyRetrofit;
import com.tmarat.retfofitandroom.model.network.WeatherRequest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Model implements Contract.Model {

  @Override public void cityNameIsOk(String cityName,
      CallBack.Response callBackResponse) {

    //cityName is Ok, does a retrofit request
    doRetrofitRequest(cityName, callBackResponse);
  }

  private void doRetrofitRequest(String cityName,
      final CallBack.Response callBackResponse) {

    //Uses a retrofit fabric method which returns Call<WeatherRequest>. Does async request
    MyRetrofit.initRetrofit(cityName).enqueue(new Callback<WeatherRequest>() {
      @Override
      public void onResponse(Call<WeatherRequest> call, Response<WeatherRequest> response) {
        if (response.body() == null) {
          callBackResponse.bodyIsNull();
        } else {
          // TODO: 03.07.2018 to add response in LiveData
        }
      }

      @Override public void onFailure(Call<WeatherRequest> call, Throwable t) {

      }
    });
  }
}
