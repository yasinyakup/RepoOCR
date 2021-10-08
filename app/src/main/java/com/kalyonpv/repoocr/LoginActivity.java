package com.kalyonpv.repoocr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.kalyonpv.repoocr.model.Login;
import com.kalyonpv.repoocr.service.LoginService;

public class LoginActivity extends AppCompatActivity {

    private EditText username, password;
    private Button submit;
    private TextView forgetPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username  = findViewById(R.id.userName);
        password = findViewById(R.id.passwordText);
        submit=findViewById(R.id.signInButton);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new LoginService().login(
                        new Login(username.getText().toString(), password.getText().toString())
                        ,LoginActivity.this
                        );
            }
        });
    }

    public void changeToMain(){
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }
}