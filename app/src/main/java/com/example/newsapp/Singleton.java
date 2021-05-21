package com.example.newsapp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Singleton {
    private static final String URL ="https://newsapi.org/v2/";
    private static Retrofit retrofit;
    private static Singleton singleton;
    private Singleton()
    {
        retrofit =new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build();
    }
    public static synchronized Singleton getInstance(){
        if (singleton ==null)
        {
            singleton = new Singleton();
        }
        return singleton;
    }
    public NewsApi getApi()
    {
        return retrofit.create(NewsApi.class);
    }
}
