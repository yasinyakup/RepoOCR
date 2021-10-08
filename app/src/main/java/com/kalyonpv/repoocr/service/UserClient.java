package com.kalyonpv.repoocr.service;

import com.kalyonpv.repoocr.model.Login;
import com.kalyonpv.repoocr.model.LoginJwt;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface UserClient {


    @POST("api/auth/login")
    Call<LoginJwt> login(@Body Login login);
}
