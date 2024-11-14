package com.example.booking_car_online.viewmodel;

import android.content.Context;

import androidx.databinding.BaseObservable;

import com.example.booking_car_online.adapter.ThanhVienAdapter;
import com.example.booking_car_online.config.AppDatabase;

public class ListThanhVienViewModel extends BaseObservable {
    private ThanhVienAdapter thanhVienAdapter;
    public void renderAdapter(Context context){
        thanhVienAdapter = new ThanhVienAdapter(context);
        thanhVienAdapter.setData(AppDatabase.getInstance(context).getThanhVienDAO().getAll());
        this.setThanhVienAdapter(thanhVienAdapter);
    }

    public ThanhVienAdapter getThanhVienAdapter() {
        return thanhVienAdapter;
    }

    public void setThanhVienAdapter(ThanhVienAdapter thanhVienAdapter) {
        this.thanhVienAdapter = thanhVienAdapter;
    }
}

