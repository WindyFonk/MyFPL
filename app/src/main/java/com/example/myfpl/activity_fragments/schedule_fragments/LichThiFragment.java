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

import com.example.myfpl.activities.MainActivity;
import com.example.myfpl.R;
import com.example.myfpl.adapters.LichHocAdapter;
import com.example.myfpl.models.LichHocModel;

import java.util.ArrayList;

public class LichThiFragment extends Fragment {
    View view;
    ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_lich_thi, container, false);
        listView = view.findViewById(R.id.lvLichThi);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog alertDialog;
                LayoutInflater mLayoutInflater = getLayoutInflater();
                View _view = mLayoutInflater.inflate(R.layout.dialog_class_detail, null);

                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext())
                        .setView(_view);
                alertDialog = builder.create();
                alertDialog.show();
            }
        });
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
        LichHocModel _class = new LichHocModel("Android Networking","22/06/2003","5","DinhNT");
        for (int i = 0; i < 2; i++) {
            list.add(_class);
        }

        LichHocAdapter adapter = new LichHocAdapter(list);
        listView.setAdapter(adapter);
    }
}