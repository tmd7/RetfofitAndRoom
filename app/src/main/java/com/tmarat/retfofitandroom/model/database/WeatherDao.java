package com.tmarat.retfofitandroom.model.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import java.util.List;

@Dao
public interface WeatherDao {

  @Query("SELECT * FROM weatherentity") List<WeatherEntity> getAll();
  @Query("SELECT * FROM weatherentity") LiveData<List<WeatherEntity>> getAllLiveData();
  @Insert void insert(WeatherEntity weatherEntity);
}
