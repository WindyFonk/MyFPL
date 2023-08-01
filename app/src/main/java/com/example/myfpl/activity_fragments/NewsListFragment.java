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
import com.example.myfpl.adapters.NewsAdapterAll;
import com.example.myfpl.models.NewsModel;

import java.util.ArrayList;

public class NewsListFragment extends Fragment {
    View view;
    RecyclerView listView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_news_list, container, false);
        listView = view.findViewById(R.id.lvNews);
        SetData();
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity) {
            MainActivity activity = (MainActivity) context;
            activity.updateImageView(2);
        }
    }

    private void SetData(){
        ArrayList<NewsModel> list = new ArrayList<>();

        NewsAdapterAll adapter = new NewsAdapterAll(requireContext(),list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext());
        listView.setLayoutManager(linearLayoutManager);
        listView.setAdapter(adapter);
    }

}