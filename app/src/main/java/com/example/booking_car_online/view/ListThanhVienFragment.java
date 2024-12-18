package com.example.booking_car_online.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.SearchView;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.booking_car_online.databinding.FragmentListThanhVienBinding;
import com.example.booking_car_online.viewmodel.ListThanhVienViewModel;

public class ListThanhVienFragment extends Fragment {
    private FragmentListThanhVienBinding fragmentListThanhVienBinding;
    private ListThanhVienViewModel listThanhVienViewModel = new ListThanhVienViewModel();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentListThanhVienBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_list_thanh_vien,container, false);

        fragmentListThanhVienBinding.setListThanhVienViewModel(listThanhVienViewModel);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());


        fragmentListThanhVienBinding.rcvThanhVien.setLayoutManager(linearLayoutManager);
        listThanhVienViewModel.renderAdapter(getContext());
        fragmentListThanhVienBinding.rcvThanhVien.setAdapter(listThanhVienViewModel.getThanhVienAdapter());
        fragmentListThanhVienBinding.searchTen.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                listThanhVienViewModel.getThanhVienAdapter().getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                listThanhVienViewModel.getThanhVienAdapter().getFilter().filter(newText);
                return false;
            }
        });

        return fragmentListThanhVienBinding.getRoot();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        listThanhVienViewModel.getThanhVienAdapter().release();
    }
}
