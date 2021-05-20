package com.example.newsapp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClientSingleton {
    private static final String URL ="https://newsapi.org/v2/";
    private static Retrofit retrofit;
    private static ClientSingleton clientSingleton;
    private ClientSingleton()
    {
        retrofit =new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build();
    }
    public static synchronized ClientSingleton getInstance(){
        if (clientSingleton ==null)
        {
            clientSingleton = new ClientSingleton();
        }
        return clientSingleton;
    }
    public Interface getApi()
    {
        return retrofit.create(Interface.class);
    }
}
