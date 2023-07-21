package com.example.myfpl.activity_fragments.schedule_fragments;

import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.myfpl.R;
import com.example.myfpl.adapters.LichHocAdapter;
import com.example.myfpl.adapters.NewsAdapter;
import com.example.myfpl.models.LichHocModel;
import com.example.myfpl.models.NewsModel;

import java.util.ArrayList;

public class NewsListFragment extends Fragment {
    View view;
    ListView listView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_news_list, container, false);
        listView = view.findViewById(R.id.lvNews);
        SetData();
        return view;
    }

    private void SetData(){
        ArrayList<NewsModel> list = new ArrayList<>();
        NewsModel _class = new NewsModel("0","Thông báo phát hành giáo trình kì Fall 2023","22/06/2003","DinhNT");
        for (int i = 0; i < 5; i++) {
            list.add(_class);
        }

        NewsAdapter adapter = new NewsAdapter(list);
        listView.setAdapter(adapter);
    }

}