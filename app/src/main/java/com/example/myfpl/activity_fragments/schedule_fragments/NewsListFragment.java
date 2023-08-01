package com.example.myfpl.activity_fragments.schedule_fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myfpl.MainActivity;
import com.example.myfpl.R;
import com.example.myfpl.adapters.NewsAdapterAll;
import com.example.myfpl.api.ServiceHelper;
import com.example.myfpl.models.BaseResponse;
import com.example.myfpl.models.NotificationModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsListFragment extends Fragment {
    View view;
    RecyclerView listView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_news_list, container, false);
        listView = view.findViewById(R.id.lvNews);
        ServiceHelper.getInstance().getNotification().enqueue(new Callback<BaseResponse<ArrayList<NotificationModel>>>() {
            @Override
            public void onResponse(@NonNull Call<BaseResponse<ArrayList<NotificationModel>>> call, @NonNull Response<BaseResponse<ArrayList<NotificationModel>>> response) {
                if (response.isSuccessful()) {
                    assert response.body() != null;
                    for ( NotificationModel notificationModel : response.body().data) {
                        Log.e(">>>>>Notification: ", notificationModel.DESCRIPTION);
                    }
                    SetData(response.body().data);
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<ArrayList<NotificationModel>>> call, Throwable t) {

            }
        });
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

    private void SetData(ArrayList<NotificationModel> data){
        NewsAdapterAll adapter = new NewsAdapterAll(requireContext(),data);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext());
        listView.setLayoutManager(linearLayoutManager);
        listView.setAdapter(adapter);
    }


}