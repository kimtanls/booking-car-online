package com.example.booking_car_online.model.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.booking_car_online.model.LoaiXe;
import com.example.booking_car_online.model.ThanhVien;

import java.util.List;

public interface LoaiXeDAO {
    @Insert
    void insert(LoaiXe... loaiXes);
    @Delete
    void delete(LoaiXe loaiXe);
    @Query("SELECT EXISTS(SELECT 1 FROM table_loaixe WHERE ten_loai_xe = :tenLoaiXe )")
    boolean isLoaiXeExist(String tenLoaiXe);
    @Query("select * from table_loaixe")
    List<LoaiXe> getAll();
    @Update
    void updateLoaiXe(LoaiXe loaiXe);
    @Query("select ten_loai_xe from table_loaixe where id_loai_xe= :idLoaiXe")
    String getTenLoaiXeByID(int idLoaiXe);

    @Query("select so_luong_ghe from table_loaixe where id_loai_xe= :idLoaiXe")
    int getSoLuongGheByID(int idLoaiXe);

    @Query("select ten_loai_xe from table_loaixe")
    List<String> getTenLoaiXe();

    @Query("select id_loai_xe from table_loaixe where ten_loai_xe= :tenLoaiXe")
    int getIDLoaiXe(String tenLoaiXe);
//    @Query("select ten_loai_xe from table_loaixe where chuyenXe.")
//    String getTenLoaiXeByChuyenXe(ChuyenXe chuyenXe);
}
