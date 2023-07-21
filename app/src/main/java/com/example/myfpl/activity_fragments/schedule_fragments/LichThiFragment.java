package com.example.myfpl.activity_fragments.schedule_fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.myfpl.R;
import com.example.myfpl.adapters.LichHocAdapter;
import com.example.myfpl.adapters.NewsAdapter;
import com.example.myfpl.models.LichHocModel;
import com.example.myfpl.models.NewsModel;

import java.util.ArrayList;

public class LichThiFragment extends Fragment {
    View view;
    ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_lich_thi, container, false);
        listView = view.findViewById(R.id.lvLichThi);
        SetData();
        return view;
    }

    private void SetData(){
        ArrayList<LichHocModel> list = new ArrayList<>();
        LichHocModel _class = new LichHocModel("Android Networking","22/06/2003","5","DinhNT");
        for (int i = 0; i < 5; i++) {
            list.add(_class);
        }

        LichHocAdapter adapter = new LichHocAdapter(list);
        listView.setAdapter(adapter);
    }
}