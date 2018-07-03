package com.tmarat.retfofitandroom.presenter;

import com.tmarat.retfofitandroom.common.CallBack;
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

      //if city name is OK uses method in model with a city name and a callback
      model.cityNameIsOk(cityName, new CallBack.Response() {
        @Override public void bodyIsNull() {

          //if response.body is null
          view.showToast(R.string.response_is_empty);
        }
      });
    }
  }
}
