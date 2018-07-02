package com.tmarat.retfofitandroom;

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
}
