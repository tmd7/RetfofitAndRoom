package com.tmarat.retfofitandroom;

public class Presenter implements Contract.Presenter {

  private Contract.View view;
  private Contract.Model model;

  Presenter(Contract.View view) {
    this.view = view;
    this.model = new Model();
  }

  @Override public void getUserInput(String cityName) {
    if (cityName.equals("")) {
      view.showToast(R.string.empty);
    } else {
      model.cityNameIsOk(cityName);
    }
  }
}
