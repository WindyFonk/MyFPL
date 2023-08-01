package com.example.myfpl.activity_fragments.schedule_fragments;

import android.content.Context;
import android.os.Bundle;
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
import com.example.myfpl.models.LichHocModel;

import java.util.ArrayList;

public class LichHocFragment extends Fragment {
    View view;
    RecyclerView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_lich_hoc, container, false);
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
        ArrayList<LichHocModel> list = new ArrayList<>();
        LichHocModel _class = new LichHocModel("Android Networking","22/06/2003","5","T304");
        for (int i = 0; i < 5; i++) {
            list.add(_class);
        }

        LichHocAdapterRecyle adapterLich = new LichHocAdapterRecyle(requireContext(), list);
        LinearLayoutManager linearLayoutManagerLich = new LinearLayoutManager(requireContext());
        listView.setLayoutManager(linearLayoutManagerLich);
        listView.setAdapter(adapterLich);
    }
}