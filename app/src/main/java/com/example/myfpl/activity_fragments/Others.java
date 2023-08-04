package com.example.myfpl.activity_fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myfpl.activities.MainActivity;
import com.example.myfpl.R;
import com.example.myfpl.adapters.LichHocAdapterRecyle;
import com.example.myfpl.adapters.MonHocAdapterRecyle;
import com.example.myfpl.api.ServiceHelper;
import com.example.myfpl.models.BaseResponse;
import com.example.myfpl.models.CourseModel;
import com.example.myfpl.models.MonHoc;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Others extends Fragment {
    View view;
    RecyclerView listView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_others, container, false);
        listView = view.findViewById(R.id.lvMonHoc);
        SetDataLich();
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity) {
            MainActivity activity = (MainActivity) context;
            activity.updateImageView(4);
        }
    }

    private void SetDataLich() {

        ServiceHelper.getInstance().getMonHoc().enqueue(new Callback<BaseResponse<ArrayList<MonHoc>>>() {
            @Override
            public void onResponse(Call<BaseResponse<ArrayList<MonHoc>>> call, Response<BaseResponse<ArrayList<MonHoc>>> response) {
                MonHocAdapterRecyle adapterLich = new MonHocAdapterRecyle(requireContext(), response.body().data);
                LinearLayoutManager linearLayoutManagerLich = new LinearLayoutManager(requireContext());
                listView.setLayoutManager(linearLayoutManagerLich);
                listView.setAdapter(adapterLich);
            }

            @Override
            public void onFailure(Call<BaseResponse<ArrayList<MonHoc>>> call, Throwable t) {

            }
        });

    }
}