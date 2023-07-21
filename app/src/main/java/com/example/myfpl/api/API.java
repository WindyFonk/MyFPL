package com.example.myfpl.api;

import com.example.myfpl.models.NewsModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {
    String base_url = "http://172.16.110.82/App/User/";

    @GET("getNews.php")
    Call<ArrayList<NewsModel>> getNews();
}
