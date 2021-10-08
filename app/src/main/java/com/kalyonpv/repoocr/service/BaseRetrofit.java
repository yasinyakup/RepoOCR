package com.kalyonpv.repoocr.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseRetrofit {
    Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl("http://10.11.80.184:8081/")
            .addConverterFactory(GsonConverterFactory.create());

    Retrofit retrofit = builder.build();
}
