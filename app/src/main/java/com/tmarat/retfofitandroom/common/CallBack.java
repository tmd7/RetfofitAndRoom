package com.tmarat.retfofitandroom.common;

import com.tmarat.retfofitandroom.model.WeatherInfoPojo;

public interface CallBack {
  interface Response {
    void failure();
  }

  interface ResponseIsOk {
    void getWeather(WeatherInfoPojo weatherInfo);
  }
}
