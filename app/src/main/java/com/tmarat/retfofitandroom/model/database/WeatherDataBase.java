package com.tmarat.retfofitandroom.model.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {WeatherEntity.class}, version = 1, exportSchema = true)
public abstract class WeatherDataBase extends RoomDatabase {
  public abstract WeatherDao weatherDao();
}
