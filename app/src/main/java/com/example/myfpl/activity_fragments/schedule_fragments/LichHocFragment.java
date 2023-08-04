package com.example.myfpl.activity_fragments.schedule_fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfpl.activities.MainActivity;
import com.example.myfpl.R;
import com.example.myfpl.adapters.LichHocAdapterRecyle;
import com.example.myfpl.api.ServiceHelper;
import com.example.myfpl.models.BaseResponse;
import com.example.myfpl.models.CourseModel;
import com.example.myfpl.models.LichHocModel;
import com.example.myfpl.models.NotificationModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LichHocFragment extends Fragment {
    View view;
    RecyclerView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_lich_hoc, container, false);
        listView = view.findViewById(R.id.lvLichThi);
        SetDataLich();
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity) {
            MainActivity activity = (MainActivity) context;
            activity.updateImageView(3);
        }
    }


    private void SetDataLich() {

        ServiceHelper.getInstance().getCourse().enqueue(new Callback<BaseResponse<ArrayList<CourseModel>>>() {
            @Override
            public void onResponse(Call<BaseResponse<ArrayList<CourseModel>>> call, Response<BaseResponse<ArrayList<CourseModel>>> response) {

                LichHocAdapterRecyle adapterLich = new LichHocAdapterRecyle(requireContext(), response.body().data);
                LinearLayoutManager linearLayoutManagerLich = new LinearLayoutManager(requireContext());
                listView.setLayoutManager(linearLayoutManagerLich);
                listView.setAdapter(adapterLich);
            }

            @Override
            public void onFailure(Call<BaseResponse<ArrayList<CourseModel>>> call, Throwable t) {

            }
        });

    }

}