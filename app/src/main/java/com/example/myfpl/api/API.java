package com.example.myfpl.api;

import com.example.myfpl.models.BaseResponse;
import com.example.myfpl.models.CourseModel;
import com.example.myfpl.models.LichThiModel;
import com.example.myfpl.models.MonHoc;
import com.example.myfpl.models.NewsModel;
import com.example.myfpl.models.NotificationModel;
import com.example.myfpl.models.UserLoginObject;
import com.example.myfpl.models.UserLoginReq;

import java.util.ArrayList;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;

public interface API {
    String base_url = "https://eelant.000webhostapp.com/api/";

    @GET("getNews.php")
    Call<ArrayList<NewsModel>> getNews();


    @FormUrlEncoded
    @POST("account/signin.php")
    Call<BaseResponse<ArrayList<UserLoginObject>>> login(
            @Field("username") String username,
            @Field("pwd") String password
    );

    @GET("notification/find-id.php?id=1")
    Call<BaseResponse<ArrayList<NotificationModel>>> getNotification();

    @GET("course/find-id.php?id=1")
    Call<BaseResponse<ArrayList<CourseModel>>> getCourse();

    @POST("course/register.php")
    Call<BaseResponse<String>> registerCourse(@Field("id_user") int id, @Field("id_course") int id_course);

    @POST("course/cancel-course.php")
    Call<BaseResponse<String>> cancelCourse(@Field("id_user") int id, @Field("id_course") int id_course);

    @GET("account/find-test-id.php?id=1")
    Call<BaseResponse<ArrayList<LichThiModel>>> getLichThi();

    @GET("course/get-all.php")
    Call<BaseResponse<ArrayList<MonHoc>>> getMonHoc();
}
