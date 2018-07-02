package com.tmarat.retfofitandroom.model.network;

import com.google.gson.annotations.SerializedName;

public class WeatherRequest {
  @SerializedName("temp")     private float temp;
  @SerializedName("pressure") private int   pressure;
  @SerializedName("humidity") private int   humidity;
  @SerializedName("temp_min") private float temp_min;
  @SerializedName("temp_max") private float temp_max;
}
