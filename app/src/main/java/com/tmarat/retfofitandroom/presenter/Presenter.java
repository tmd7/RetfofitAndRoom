package com.tmarat.retfofitandroom.presenter;

import com.tmarat.retfofitandroom.common.Contract;
import com.tmarat.retfofitandroom.model.Model;
import com.tmarat.retfofitandroom.R;

public class Presenter implements Contract.Presenter {

  private Contract.View view;
  private Contract.Model model;

  public Presenter(Contract.View view) {
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
