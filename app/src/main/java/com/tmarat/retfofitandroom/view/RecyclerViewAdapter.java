package com.tmarat.retfofitandroom.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tmarat.retfofitandroom.R;
import com.tmarat.retfofitandroom.model.database.WeatherEntity;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.Holder> {

  private List<WeatherEntity> weatherList;

  public RecyclerViewAdapter(
      List<WeatherEntity> weatherList) {
    this.weatherList = weatherList;
  }

  @NonNull @Override
  public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
    return new Holder(view);
  }

  @Override public void onBindViewHolder(@NonNull Holder holder, int position) {
    holder.cityName.setText(weatherList.get(position).getCityName());
    holder.tem.setText(String.valueOf(weatherList.get(position).getTem()));
    holder.hum.setText(weatherList.get(position).getHum());
    holder.press.setText(weatherList.get(position).getPress());
  }

  @Override public int getItemCount() {
    return 0;
  }

  class Holder extends RecyclerView.ViewHolder {
    TextView cityName;
    TextView tem;
    TextView hum;
    TextView press;

    Holder(View itemView) {
      super(itemView);
      cityName = itemView.findViewById(R.id.item_city);
      tem = itemView.findViewById(R.id.item_tem);
      hum = itemView.findViewById(R.id.item_hum);
      press = itemView.findViewById(R.id.item_press);
    }
  }
}
