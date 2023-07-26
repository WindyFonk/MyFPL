package com.example.myfpl.api;

import com.example.myfpl.models.BaseResponse;
import com.example.myfpl.models.NewsModel;
import com.example.myfpl.models.UserLoginObject;
import com.example.myfpl.models.UserLoginReq;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface API {
    String base_url = "https://eelant.000webhostapp.com/api/";

    @GET("getNews.php")
    Call<ArrayList<NewsModel>> getNews();


    @POST("account/signin.php")
    Call<BaseResponse<ArrayList<UserLoginObject>>> login(@Body UserLoginReq userLoginReq);
}
