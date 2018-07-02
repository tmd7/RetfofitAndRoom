package com.tmarat.retfofitandroom.common;
public interface Contract {

  interface View {
    void showToast(int resId);
  }

  interface Presenter {

    void getUserInput(String cityName);
  }

  interface Model {

    void cityNameIsOk(String cityName);
  }

  interface OpenWeather {
  }
}
