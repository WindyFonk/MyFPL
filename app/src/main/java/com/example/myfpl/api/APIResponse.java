package com.example.myfpl.api;

import androidx.annotation.NonNull;

import com.example.myfpl.models.BaseResponse;
import com.example.myfpl.models.CourseModel;
import com.example.myfpl.models.LichThiModel;
import com.example.myfpl.models.MonHoc;
import com.example.myfpl.models.NotificationModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class APIResponse {

    public ArrayList<NotificationModel> getNotification() {
        final ArrayList<NotificationModel> list = new ArrayList<>();

        ServiceHelper.getInstance().getNotification().enqueue(new Callback<BaseResponse<ArrayList<NotificationModel>>>() {
            @Override
            public void onResponse(@NonNull Call<BaseResponse<ArrayList<NotificationModel>>> call, @NonNull Response<BaseResponse<ArrayList<NotificationModel>>> response) {
                if (response.isSuccessful()) {
                    assert response.body() != null;
                    list.addAll(response.body().data);
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<ArrayList<NotificationModel>>> call, Throwable t) {

            }
        });
        return list;
    }

    public ArrayList<CourseModel> getCourse() {
        final ArrayList<CourseModel> list = new ArrayList<>();
        return list;
    }

    public String registerCourse(int course) {
        final String[] result = new String[1];

        ServiceHelper.getInstance().registerCourse(course).enqueue(new Callback<BaseResponse<String>>() {
            @Override
            public void onResponse(@NonNull Call<BaseResponse<String>> call, @NonNull Response<BaseResponse<String>> response) {
                if (response.isSuccessful()) {
                    assert response.body() != null;
                    result[0] = response.body().data;
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<String>> call, Throwable t) {

            }
        });
        return result[0];
    }

    public String cancelCourse(int course) {
        final String[] result = new String[1];

        ServiceHelper.getInstance().cancelCourse(course).enqueue(new Callback<BaseResponse<String>>() {
            @Override
            public void onResponse(@NonNull Call<BaseResponse<String>> call, @NonNull Response<BaseResponse<String>> response) {
                if (response.isSuccessful()) {
                    assert response.body() != null;
                    result[0] = response.body().data;
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<String>> call, Throwable t) {

            }
        });
        return result[0];
    }

    public ArrayList<LichThiModel> getLichThi() {
        final ArrayList<LichThiModel> list = new ArrayList<>();
        ServiceHelper.getInstance().getLichThi().enqueue(new Callback<BaseResponse<ArrayList<LichThiModel>>>() {
            @Override
            public void onResponse(@NonNull Call<BaseResponse<ArrayList<LichThiModel>>> call, @NonNull Response<BaseResponse<ArrayList<LichThiModel>>> response) {
                if (response.isSuccessful()) {
                    assert response.body() != null;
                    list.addAll(response.body().data);
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<ArrayList<LichThiModel>>> call, Throwable t) {

            }
        });
        return list;
    }

    public ArrayList<MonHoc> getMonHoc(){
        final ArrayList<MonHoc> list = new ArrayList<>();
        ServiceHelper.getInstance().getMonHoc().enqueue(new Callback<BaseResponse<ArrayList<MonHoc>>>() {
            @Override
            public void onResponse(@NonNull Call<BaseResponse<ArrayList<MonHoc>>> call, @NonNull Response<BaseResponse<ArrayList<MonHoc>>> response) {
                if (response.isSuccessful()) {
                    assert response.body() != null;
                    list.addAll(response.body().data);
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<ArrayList<MonHoc>>> call, Throwable t) {

            }
        });
        return list;
    }
}
