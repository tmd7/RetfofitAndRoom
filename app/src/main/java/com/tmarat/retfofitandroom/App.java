package com.tmarat.retfofitandroom;

import android.app.Application;
import android.arch.persistence.room.Room;
import com.tmarat.retfofitandroom.model.database.WeatherDataBase;

public class App extends Application {

  public static App instance;

  private WeatherDataBase dataBase;

  @Override public void onCreate() {
    super.onCreate();
    instance = this;
    dataBase = Room.databaseBuilder(this, WeatherDataBase.class, "main_db").build();
  }

  public static App getInstance() {
    return instance;
  }

  public WeatherDataBase getDataBase() {
    return dataBase;
  }
}
