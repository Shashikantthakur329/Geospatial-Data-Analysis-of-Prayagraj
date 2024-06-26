package com.shubham.groundtruthcollection;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CsvDataAdapter extends RecyclerView.Adapter<CsvDataAdapter.ViewHolder> {

    private List<String> dataList;

    public CsvDataAdapter(List<String> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.csv_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String[] rowData = dataList.get(position).split(",");
        holder.srNoTextView.setText(String.valueOf(position + 1));
        holder.latitudeTextView.setText(rowData[0]);
        holder.longitudeTextView.setText(rowData[1]);
        holder.classNameTextView.setText(rowData[2]);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView srNoTextView, latitudeTextView, longitudeTextView, classNameTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            srNoTextView = itemView.findViewById(R.id.srNoTextView);
            latitudeTextView = itemView.findViewById(R.id.latitudeTextView);
            longitudeTextView = itemView.findViewById(R.id.longitudeTextView);
            classNameTextView = itemView.findViewById(R.id.classNameTextView);
        }
    }
}
