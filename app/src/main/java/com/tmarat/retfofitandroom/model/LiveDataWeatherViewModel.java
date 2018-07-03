package com.tmarat.retfofitandroom.model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.Nullable;

public class LiveDataWeatherViewModel extends ViewModel{

  @Nullable
  private MutableLiveData<WeatherInfoPojo> liveDataWeather = new MutableLiveData<>();

  public LiveDataWeatherViewModel() {

  }

  public MutableLiveData<WeatherInfoPojo> getLiveDataWeather() {
    if (liveDataWeather == null) {
      liveDataWeather = new MutableLiveData<>();
    }
    return liveDataWeather;
  }
}
