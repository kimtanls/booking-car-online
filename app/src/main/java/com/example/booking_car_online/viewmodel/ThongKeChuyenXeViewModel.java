package com.example.booking_car_online.viewmodel;

import android.content.Context;

import androidx.databinding.BaseObservable;

import com.example.booking_car_online.adapter.ThongKeChuyenXeAdapter;
import com.example.booking_car_online.config.AppDatabase;
import com.example.booking_car_online.model.ChuyenXe;
import com.example.booking_car_online.model.DAO.ChuyenXeDAO;

import java.util.List;

public class ThongKeChuyenXeViewModel extends BaseObservable {
    private ThongKeChuyenXeAdapter thongKeChuyenXeAdapter;

    public void renderAdapter(Context context){
        thongKeChuyenXeAdapter = new ThongKeChuyenXeAdapter(context);
        ChuyenXeDAO chuyenXeDAO = AppDatabase.getInstance(context).getChuyenXeDAO();
        List<ChuyenXe> listChuyenXe = chuyenXeDAO.getAll();
        thongKeChuyenXeAdapter.setData(listChuyenXe);
        setThongKeChuyenXeAdapter(thongKeChuyenXeAdapter);
    }

    public ThongKeChuyenXeAdapter getThongKeChuyenXeAdapter() {
        return thongKeChuyenXeAdapter;
    }
booking_car_online(ThongKeChuyenXeAdapter thongKeChuyenXeAdapter) {
        this.thongKeChuyenXeAdapter = thongKeChuyenXeAdapter;
    }
}
