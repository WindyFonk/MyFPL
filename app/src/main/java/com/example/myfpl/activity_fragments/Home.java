package com.example.myfpl.activity_fragments;

import android.content.DialogInterface;
import android.os.Bundle;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myfpl.R;
import com.example.myfpl.activity_fragments.schedule_fragments.LichThiFragment;
import com.example.myfpl.activity_fragments.schedule_fragments.NewsListFragment;
import com.example.myfpl.adapters.LichHocAdapterRecyle;
import com.example.myfpl.adapters.NewsAdapter;
import com.example.myfpl.adapters.NewsAdapterRecyle;
import com.example.myfpl.api.API;
import com.example.myfpl.models.LichHocModel;
import com.example.myfpl.models.NewsModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import retrofit2.Retrofit;

public class Home extends Fragment {

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    View view;
    RecyclerView newsListview,scheduleListview;
    ImageView btnLogout;
    TextView btnAllNews, btnAllSchedules;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
        newsListview = view.findViewById(R.id.lvNews);
        scheduleListview = view.findViewById(R.id.lvLichHoc);
        SetData();
        SetDataLich();

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Gson gson = new GsonBuilder()
                .setLenient()
                .create();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API.base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        API service = retrofit.create(API.class);

        Call<ArrayList<NewsModel>> response = service.getNews();
        response.enqueue(new Callback<ArrayList<NewsModel>>() {
            @Override
            public void onResponse(Call<ArrayList<NewsModel>> call, Response<ArrayList<NewsModel>> response) {
                ArrayList<NewsModel> listNews = response.body();
                NewsAdapter adapter = new NewsAdapter(listNews);
                //newsListview.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ArrayList<NewsModel>> call, Throwable t) {
                    Log.d(">>>>>>>>>>>ASD",t.toString());
            }
        });

    }

    private void SetData(){
        ArrayList<NewsModel> list = new ArrayList<>();
        NewsModel news = new NewsModel("0","THÔNG BÁO NHẬN BẰNG TỐT NGHIỆP" +
                "(ĐỢT TỐT NGHIỆP THÁNG 06/2023)","22/06/2003","TamNB");
        for (int i = 0; i < 5; i++) {
            list.add(news);
        }

        NewsAdapterRecyle adapter = new NewsAdapterRecyle(requireContext(),list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext());
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        newsListview.setLayoutManager(linearLayoutManager);
        newsListview.setAdapter(adapter);
    }

    private void SetDataLich(){
        ArrayList<LichHocModel> listLich = new ArrayList<>();
        LichHocModel lich = new LichHocModel("Android Networking","20/05/2023","5: 17:30 - 19:30","T305");
        for (int i = 0; i < 5; i++) {
            listLich.add(lich);
        }

        LichHocAdapterRecyle adapterLich = new LichHocAdapterRecyle(requireContext(),listLich);
        LinearLayoutManager linearLayoutManagerLich = new LinearLayoutManager(requireContext());
        linearLayoutManagerLich.setOrientation(RecyclerView.HORIZONTAL);
        scheduleListview.setLayoutManager(linearLayoutManagerLich);
        scheduleListview.setAdapter(adapterLich);
    }


    private void ReplaceFragment(Fragment fragment) {
        fragmentManager = getParentFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer, fragment, null);
        fragmentTransaction.commit();
    }
}