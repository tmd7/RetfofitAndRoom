package com.tmarat.retfofitandroom.model.network.jsonpojo;

import com.google.gson.annotations.SerializedName;

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
