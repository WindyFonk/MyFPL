package com.example.myfpl.api;

import com.example.myfpl.models.BaseResponse;
import com.example.myfpl.models.NewsModel;
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

    @GET("notification/find-id.php?id=1")
    Call<ArrayList<NewsModel>> getNews();


    @FormUrlEncoded
    @POST("account/signin.php")
    Call<BaseResponse<ArrayList<UserLoginObject>>> login(
            @Field("username") String username,
            @Field("pwd") String password
    );
}
