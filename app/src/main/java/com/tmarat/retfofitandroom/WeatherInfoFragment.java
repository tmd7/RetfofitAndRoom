package com.tmarat.retfofitandroom;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class WeatherInfoFragment extends Fragment implements Contract.View{
  private EditText editTextCity;
  private TextView textViewCity;
  private TextView textViewTem;
  private TextView textViewHum;
  private TextView textViewPress;
  private RecyclerView recyclerView;

  @Nullable @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_weather_info, container, false);
    initUI(view);
    setButtonOnClickListener(view);
    return view;
  }

  private void initUI(View view) {
    editTextCity = view.findViewById(R.id.edit_city);
    textViewCity = view.findViewById(R.id.text_view_city);
    textViewTem = view.findViewById(R.id.text_view_tem);
    textViewHum = view.findViewById(R.id.text_view_hum);
    textViewPress = view.findViewById(R.id.text_view_press);
  }

  private void setButtonOnClickListener(View view) {
    view.findViewById(R.id.bt_ok).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        //some event
      }
    });
  }
}
