package com.example.myfpl.activity_fragments.schedule_fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfpl.activities.MainActivity;
import com.example.myfpl.R;
import com.example.myfpl.adapters.LichHocAdapter;
import com.example.myfpl.adapters.LichHocAdapterRecyle;
import com.example.myfpl.adapters.LichThiAdapterRecyle;
import com.example.myfpl.api.ServiceHelper;
import com.example.myfpl.models.BaseResponse;
import com.example.myfpl.models.LichHocModel;
import com.example.myfpl.models.LichThiModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LichThiFragment extends Fragment {
    View view;
    RecyclerView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_lich_thi, container, false);
        listView = view.findViewById(R.id.lvLichThi);
        SetData();
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

    private void SetData(){
        ServiceHelper.getInstance().getLichThi().enqueue(new Callback<BaseResponse<ArrayList<LichThiModel>>>() {
            @Override
            public void onResponse(Call<BaseResponse<ArrayList<LichThiModel>>> call, Response<BaseResponse<ArrayList<LichThiModel>>> response) {
                LichThiAdapterRecyle adapterLich = new LichThiAdapterRecyle(requireContext(), response.body().data);
                LinearLayoutManager linearLayoutManagerLich = new LinearLayoutManager(requireContext());
                listView.setLayoutManager(linearLayoutManagerLich);
                listView.setAdapter(adapterLich);
            }

            @Override
            public void onFailure(Call<BaseResponse<ArrayList<LichThiModel>>> call, Throwable t) {

            }
        });
    }
}