package com.kalyonpv.repoocr.service;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.kalyonpv.repoocr.LoginActivity;
import com.kalyonpv.repoocr.MainActivity;
import com.kalyonpv.repoocr.model.Login;
import com.kalyonpv.repoocr.model.LoginJwt;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginService extends BaseRetrofit {

    UserClient userClient = retrofit.create(UserClient.class);

    public void login(Login login, Context context){
        Call<LoginJwt> call = userClient.login(login);

        call.enqueue(new Callback<LoginJwt>() {
            @Override
            public void onResponse(Call<LoginJwt> call, Response<LoginJwt> response) {
                if(response.isSuccessful()){
                    Toast.makeText(context, response.body().getToken(), Toast.LENGTH_LONG);
                    Intent intent = new Intent(context, MainActivity.class);
                    context.startActivity(intent);
                }else {
                    Toast.makeText(context, "Yanlış kullanıcı adı veya şifre", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<LoginJwt> call, Throwable t) {
                Toast.makeText(context, "Giriş başarısız", Toast.LENGTH_LONG).show();
            }
        });
    }
}
