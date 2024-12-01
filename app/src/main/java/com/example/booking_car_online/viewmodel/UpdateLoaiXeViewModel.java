package com.example.booking_car_online.viewmodel;


import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.fragment.app.FragmentTransaction;

import com.example.booking_car_online.BR;
import com.example.booking_car_online.R;
import com.example.booking_car_online.config.AppDatabase;
import com.example.booking_car_online.model.DAO.LoaiXeDAO;
import com.example.booking_car_online.model.LoaiXe;
import com.example.booking_car_online.view.ListLoaiXeFragment;

public class UpdateLoaiXeViewModel extends BaseObservable {
    private String tenLoaiXe;
    private String soLuongGhe;

    public void showDetaiLoaiXe(LoaiXe loaiXe, Context context){
        this.setTenLoaiXe(loaiXe.getTenLoaiXe());
        this.setSoLuongGhe(String.valueOf(loaiXe.getSoLuongGhe()) );
    }

    public void updateLoaiXe(LoaiXe loaiXe, Context context){
        if (!TextUtils.isEmpty(tenLoaiXe) || !TextUtils.isEmpty(soLuongGhe)) {
            LoaiXeDAO loaiXeDAO = AppDatabase.getInstance(context).getLoaiXeDAO();
            loaiXe.setTenLoaiXe(getTenLoaiXe());
            loaiXe.setSoLuongGhe(Integer.parseInt(getSoLuongGhe()));
            loaiXeDAO.updateLoaiXe(loaiXe);
            Toast.makeText(context, "Chỉnh sửa thành công",Toast.LENGTH_LONG).show();
            goToListFragment(context);
        }else{

            Toast.makeText(context, " Tên Loại xe và số lượng ghế không được trống ",Toast.LENGTH_LONG).show();

        }
    }

    public void goToListFragment(Context context){
        ListLoaiXeFragment listLoaiXeFragment =new ListLoaiXeFragment();
        FragmentTransaction fragmentTransaction = ((AppCompatActivity) context).getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.containerLoaiXeManager, listLoaiXeFragment);
        fragmentTransaction.commit();
    }
    @Bindable
    public void setSoLuongGhe(String soLuongGhe) {
        this.soLuongGhe = soLuongGhe;
        notifyPropertyChanged(BR.soLuongGhe);
    }
    public String getSoLuongGhe(){
        return soLuongGhe;
    }
    @Bindable
    public String getTenLoaiXe(){
        return tenLoaiXe;
    }
    public void setTenLoaiXe(String tenLoaiXe){
        this.tenLoaiXe = tenLoaiXe;
        notifyPropertyChanged(BR.tenLoaiXe);
    }


}