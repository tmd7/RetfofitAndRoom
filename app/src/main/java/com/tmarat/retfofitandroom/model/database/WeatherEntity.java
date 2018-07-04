package com.tmarat.retfofitandroom.model.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class WeatherEntity {

  @PrimaryKey
  @NonNull
  @ColumnInfo(name = "cityName")
  private String cityName;

  @ColumnInfo(name = "tem")
  private float tem;

  @ColumnInfo(name = "hum")
  private int hum;

  @ColumnInfo(name = "press")
  private int press;

  @NonNull public String getCityName() {
    return cityName;
  }

  public void setCityName(@NonNull String cityName) {
    this.cityName = cityName;
  }

  public float getTem() {
    return tem;
  }

  public void setTem(float tem) {
    this.tem = tem;
  }

  public int getHum() {
    return hum;
  }

  public void setHum(int hum) {
    this.hum = hum;
  }

  public int getPress() {
    return press;
  }

  public void setPress(int press) {
    this.press = press;
  }
}
