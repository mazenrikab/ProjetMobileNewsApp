package com.example.newsapp;

import com.example.newsapp.parameter.Headlines;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApi {
    @GET("top-headlines")
    Call<Headlines> getHeadlines(
        @Query("country") String country,
                @Query("apikey") String apikey
    );
}
