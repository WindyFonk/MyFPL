package com.example.myfpl.fragments;

import android.os.Bundle;

import retrofit2.converter.gson.GsonConverterFactory;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myfpl.R;
import com.example.myfpl.api.API;
import com.example.myfpl.models.News;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Retrofit;

public class Home extends Fragment {
    View view;
    List<News> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API.base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();




    }
}