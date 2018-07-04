package com.tmarat.retfofitandroom.common.pojo;

import com.google.gson.annotations.SerializedName;
import com.tmarat.retfofitandroom.common.pojo.Main;

public class WeatherRequest {
  @SerializedName("main") private Main main;
  @SerializedName("name") private String name;

  public Main getMain() {
    return main;
  }

  public String getName() {
    return name;
  }
}
