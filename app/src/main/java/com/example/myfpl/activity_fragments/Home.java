package com.example.myfpl.activity_fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
import android.widget.TextView;

import com.example.myfpl.activities.LoginActivity;
import com.example.myfpl.activities.MainActivity;
import com.example.myfpl.R;
import com.example.myfpl.adapters.LichHocAdapterRecyle;
import com.example.myfpl.adapters.NewsAdapterRecyle;
import com.example.myfpl.api.ServiceHelper;
import com.example.myfpl.models.LichHocModel;
import com.example.myfpl.models.NewsModel;

import java.util.ArrayList;

public class Home extends Fragment {

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    View view;
    MainActivity activity;
    RecyclerView newsListview, scheduleListview;
    ImageView btnLogout;
    TextView btnAllNews, btnAllSchedules;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
        newsListview = view.findViewById(R.id.lvNews);
        scheduleListview = view.findViewById(R.id.lvLichhoc);

        CallAPINews();

        SetDataLich();

        btnLogout = view.findViewById(R.id.btnLogout);
        btnAllNews = view.findViewById(R.id.tvAllNews);
        btnAllSchedules = view.findViewById(R.id.tvAllLich);

        //Thay anh theo fragment
        Context context = requireContext();
        activity = (MainActivity) context;
        if (context instanceof MainActivity) {
            activity.updateImageView(1);
        }

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LogOut();
            }
        });

        btnAllNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ReplaceFragment(new NewsListFragment());
                activity.bottomNavigation.show(2, true);
            }
        });

        btnAllSchedules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ReplaceFragment(new Schedule());
                activity.bottomNavigation.show(3, true);
            }
        });
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        CallAPINews();
    }

    private void SetDataLich() {
        ArrayList<LichHocModel> listLich = new ArrayList<>();
        LichHocModel lich = new LichHocModel("Android Networking", "20/05/2023", "5", "T305");
        for (int i = 0; i < 5; i++) {
            listLich.add(lich);
        }

        LichHocAdapterRecyle adapterLich = new LichHocAdapterRecyle(requireContext(), listLich);
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

    private void CallAPINews() {
        ServiceHelper.getInstance().getNews()
                .enqueue(new Callback<ArrayList<NewsModel>>() {
                    @Override
                    public void onResponse(Call<ArrayList<NewsModel>> call, Response<ArrayList<NewsModel>> response) {
                        ArrayList<NewsModel> list = response.body();
                        Log.d("List", list.toString());
                    }

                    @Override
                    public void onFailure(Call<ArrayList<NewsModel>> call, Throwable t) {
                        Log.e(">>>Get Data failed", "onFailure: ", t);
                    }
                });
    }

    public void LogOut(){
        Intent intent= new Intent(requireContext(), LoginActivity.class);

        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setTitle("Đăng xuất");
        builder.setMessage("Bạn có muốn đăng xuất khỏi tài khoản này?");

// Set positive button
        builder.setPositiveButton("Đăng xuất", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(intent);
            }
        });

// Set negative button
        builder.setNegativeButton("Quay lại", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // User clicked No button
                // Perform the desired action here
            }
        });

// Create and show the dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}