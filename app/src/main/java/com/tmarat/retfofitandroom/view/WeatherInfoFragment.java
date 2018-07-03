package com.tmarat.retfofitandroom.view;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tmarat.retfofitandroom.common.Contract;
import com.tmarat.retfofitandroom.model.LiveDataWeatherViewModel;
import com.tmarat.retfofitandroom.model.WeatherInfoPojo;
import com.tmarat.retfofitandroom.presenter.Presenter;
import com.tmarat.retfofitandroom.R;

public class WeatherInfoFragment extends Fragment implements Contract.View {
  private static final String TAG = WeatherInfoFragment.class.getSimpleName();

  private EditText editTextCityName;
  private TextView textViewCity;
  private TextView textViewTem;
  private TextView textViewHum;
  private TextView textViewPress;
  private RecyclerView recyclerView;

  private Contract.Presenter presenter;

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    presenter = new Presenter(this);
  }

  @Nullable @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_weather_info, container, false);
    initUI(view);
    setButtonOnClickListener(view);
    return view;
  }

  private void initUI(View view) {
    editTextCityName = view.findViewById(R.id.edit_city);
    textViewCity = view.findViewById(R.id.text_view_city);
    textViewTem = view.findViewById(R.id.text_view_tem);
    textViewHum = view.findViewById(R.id.text_view_hum);
    textViewPress = view.findViewById(R.id.text_view_press);
  }

  private void setButtonOnClickListener(View view) {
    view.findViewById(R.id.bt_ok).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        presenter.getUserInput(editTextCityName.getText().toString());
        setWeatherFromLiveData();
      }
    });
  }

  private void setWeatherFromLiveData() {
    LiveDataWeatherViewModel model = ViewModelProviders
        .of(this)
        .get(LiveDataWeatherViewModel.class);

    LiveData<WeatherInfoPojo> liveData = model.getLiveDataWeather();
    liveData.observe(this, new Observer<WeatherInfoPojo>() {
      @Override public void onChanged(@Nullable WeatherInfoPojo weatherInfoPojo) {
        Log.d(TAG, "onChanged: live data is change");
        textViewCity.setText(weatherInfoPojo.getCityName());
        textViewTem.setText(weatherInfoPojo.getTem());
        textViewHum.setText(weatherInfoPojo.getHum());
        textViewPress.setText(weatherInfoPojo.getPress());
      }
    });
  }

  @Override public void showToast(int resId) {
    Toast.makeText(getContext(),resId, Toast.LENGTH_SHORT).show();
  }
}
