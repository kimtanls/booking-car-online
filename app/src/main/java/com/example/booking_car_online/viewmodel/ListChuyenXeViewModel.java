package com.example.booking_car_online.viewmodel;

import android.content.Context;

import androidx.databinding.BaseObservable;

import com.example.booking_car_online.adapter.ChuyenXeAdapter;
import com.example.booking_car_online.config.AppDatabase;

public class ListChuyenXeViewModel extends BaseObservable {
    private ChuyenXeAdapter chuyenXeAdapter;
    public void renderAdapter(Context context){
        chuyenXeAdapter = new ChuyenXeAdapter(context);
        chuyenXeAdapter.setData(AppDatabase.getInstance(context).getChuyenXeDAO().getAll());
        this.setChuyenXeAdapter(chuyenXeAdapter);
    }

    public ChuyenXeAdapter getChuyenXeAdapter() {
        return chuyenXeAdapter;
    }

    public void setChuyenXeAdapter(ChuyenXeAdapter chuyenXeAdapter) {
        this.chuyenXeAdapter = chuyenXeAdapter;
    }
}