package com.tmarat.retfofitandroom.common;

import com.tmarat.retfofitandroom.common.pojo.WeatherInfo;

public interface CallBack {
  interface Response {
    void failure();
  }

  interface ResponseIsOk {
    void getWeather(WeatherInfo weatherInfo);
  }
}
