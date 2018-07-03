package com.tmarat.retfofitandroom.model.network;

import com.google.gson.annotations.SerializedName;

public class WeatherRequest {
  @SerializedName("temp")     private float temp;
  @SerializedName("pressure") private int   pressure;
  @SerializedName("humidity") private int   humidity;
  @SerializedName("temp_min") private float temp_min;
  @SerializedName("temp_max") private float temp_max;

  public float getTemp() {
    return temp;
  }

  public int getPressure() {
    return pressure;
  }

  public int getHumidity() {
    return humidity;
  }

  public float getTemp_min() {
    return temp_min;
  }

  public float getTemp_max() {
    return temp_max;
  }
}
