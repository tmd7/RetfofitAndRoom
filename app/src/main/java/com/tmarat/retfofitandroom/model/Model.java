package com.tmarat.retfofitandroom.model;

import com.tmarat.retfofitandroom.common.Contract;
import com.tmarat.retfofitandroom.model.network.MyRetrofit;

public class Model implements Contract.Model {



  @Override public void cityNameIsOk(String cityName) {
    new MyRetrofit(cityName);
  }
}
