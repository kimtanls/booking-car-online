package com.example.booking_car_online.config;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.example.booking_car_online.model.ChuyenXe;
import com.example.booking_car_online.model.DAO.ChuyenXeDAO;
import com.example.booking_car_online.model.DAO.DanhGiaDAO;
import com.example.booking_car_online.model.DAO.DatVeDAO;
import com.example.booking_car_online.model.DAO.LoaiXeDAO;
import com.example.booking_car_online.model.DAO.QuyenDao;
import com.example.booking_car_online.model.DAO.ThanhVienDAO;
import com.example.booking_car_online.model.DAO.TrangThaiDAO;
import com.example.booking_car_online.model.DanhGia;
import com.example.booking_car_online.model.DatVe;
import com.example.booking_car_online.model.LoaiXe;
import com.example.booking_car_online.model.Quyen;
import com.example.booking_car_online.model.ThanhVien;
import com.example.booking_car_online.model.TrangThai;

@Database(version = 1,
    entities = {
            ThanhVien.class,
            Quyen.class,
            ChuyenXe.class,
            LoaiXe.class,
            DanhGia.class,
            DatVe.class,
            TrangThai.class,
    }
    , exportSchema = false
)
public abstract class AppDatabase extends RoomDatabase {


    public abstract ThanhVienDAO getThanhVienDAO();
    public abstract QuyenDao getQuyenDAO();
    public abstract ChuyenXeDAO getChuyenXeDAO();
    public abstract LoaiXeDAO getLoaiXeDAO();
    public abstract DanhGiaDAO getDanhGiaDAO();
    public abstract DatVeDAO getVeXeDAO();
    public abstract TrangThaiDAO getTrangThaiDAO();
    private static AppDatabase instance;
    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "doanandroid.db")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}
