package com.example.myfpl.api;

import static com.example.myfpl.api.API.base_url;

import com.example.myfpl.models.BaseResponse;
import com.example.myfpl.models.NewsModel;
import com.example.myfpl.models.CourseModel;
import com.example.myfpl.models.LichThiModel;
import com.example.myfpl.models.MonHoc;
import com.example.myfpl.models.NotificationModel;
import com.example.myfpl.models.UserLoginObject;
import com.example.myfpl.models.UserLoginReq;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceHelper {
    private static OkHttpClient.Builder httpClient;
    private static ServiceHelper instance;
    private final API service;

    private ServiceHelper() {
        httpClient = new OkHttpClient.Builder();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient.interceptors().add(interceptor);
        Retrofit retrofit = createAdapter().build();
        service = retrofit.create(API.class);
    }

    public static ServiceHelper getInstance() {
        if (instance == null) {
            instance = new ServiceHelper();
        }
        return instance;
    }

    private Retrofit.Builder createAdapter() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        return new Retrofit.Builder()
                .baseUrl(base_url)
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create());
    }

    public Call<BaseResponse<ArrayList<UserLoginObject>>> login(UserLoginReq userLoginReq) {
        return service.login(userLoginReq.username, userLoginReq.pwd);
    }

    public Call<BaseResponse<ArrayList<NotificationModel>>> getNotification() {
        return service.getNotification();
    }

    public Call<BaseResponse<ArrayList<CourseModel>>> getCourse() {
        return service.getCourse();
    }

    public Call<BaseResponse<String>> registerCourse(int course) {
        return service.registerCourse(1,course);
    }

    public Call<BaseResponse<String>> cancelCourse(int course) {
        return service.cancelCourse(1,course);
    }

    public Call<BaseResponse<ArrayList<LichThiModel>>> getLichThi() {
        return service.getLichThi();
    }

    public Call<BaseResponse<ArrayList<MonHoc>>> getMonHoc() {
        return service.getMonHoc();
    }
}
