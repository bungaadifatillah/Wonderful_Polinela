package com.kevin.polinelainfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;

public class AdapterList extends RecyclerView.Adapter<AdapterList.ViewHolder> {

    Context context;
    ArrayList<HashMap<String, String>> list_data;

    public AdapterList(JurusanEkbis jurusanEkbis, ArrayList<HashMap<String, String>> list_data) {
        this.context = jurusanEkbis;
        this.list_data = list_data;
    }

    public AdapterList(JurusanKebun jurusanKebun, ArrayList<HashMap<String, String>> list_data) {
        this.context = jurusanKebun;
        this.list_data = list_data;
    }

    public AdapterList(JurusanPangan jurusanPangan, ArrayList<HashMap<String, String>> list_data) {
        this.context = jurusanPangan;
        this.list_data = list_data;
    }

    public AdapterList(JurusanTektan jurusanTektan, ArrayList<HashMap<String, String>> list_data) {
        this.context = jurusanTektan;
        this.list_data = list_data;
    }

    public AdapterList(JurusanPeternakan jurusanPeternakan, ArrayList<HashMap<String, String>> list_data) {
        this.context = jurusanPeternakan;
        this.list_data = list_data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_adapter, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txthape.setText(list_data.get(position).get("nm_prodi"));

    }

    @Override
    public int getItemCount() {
        return list_data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CheckBox txthape;

        public ViewHolder(View itemView) {
            super(itemView);


        }
    }
}