package com.example.booking_car_online.viewmodel;

import android.content.Context;

import androidx.databinding.BaseObservable;

import com.example.booking_car_online.adapter.ThongKeNguoiDungAdapter;
import com.example.booking_car_online.config.AppDatabase;
import com.example.booking_car_online.model.DAO.ThanhVienDAO;
import com.example.booking_car_online.model.ThanhVien;

import java.util.List;

public class ThongKeNguoiDungViewModel extends BaseObservable {
    private ThongKeNguoiDungAdapter thongKeNguoiDungAdapter;

    public void renderAdapter(Context context){
        thongKeNguoiDungAdapter = new ThongKeNguoiDungAdapter(context);
        ThanhVienDAO thanhVienDAO = AppDatabase.getInstance(context).getThanhVienDAO();
        List<ThanhVien> list = thanhVienDAO.getThanhVienByIdQuyen(3);
        thongKeNguoiDungAdapter.setData(list);
        setThongKeNguoiDungAdapter(thongKeNguoiDungAdapter);

    }

    public ThongKeNguoiDungAdapter getThongKeNguoiDungAdapter() {
        return thongKeNguoiDungAdapter;
    }

    public void setThongKeNguoiDungAdapter(ThongKeNguoiDungAdapter thongKeNguoiDungAdapter) {
        this.thongKeNguoiDungAdapter = thongKeNguoiDungAdapter;
    }
}
