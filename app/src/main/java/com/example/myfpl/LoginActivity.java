package com.example.myfpl;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myfpl.api.API;
import com.example.myfpl.models.BaseResponse;
import com.example.myfpl.models.UserLoginObject;
import com.example.myfpl.models.UserLoginReq;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    ImageView btnGoogleSignin;
    EditText etEmail, etPassword;

    Button btnLogin;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnGoogleSignin = findViewById(R.id.btnGoogleSignin);
        etEmail = findViewById(R.id.editTextUserName);
        btnLogin = findViewById(R.id.btnLogin);
        etPassword = findViewById(R.id.editTextPassword);
        btnGoogleSignin.setOnClickListener(view -> {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        });
        btnLogin.setOnClickListener(view -> {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(API.base_url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            API service = retrofit.create(API.class);

            Call<BaseResponse<ArrayList<UserLoginObject>>> call = service.login(new UserLoginReq(etEmail.getText().toString(), etPassword.getText().toString()));
            call.enqueue(new Callback<BaseResponse<ArrayList<UserLoginObject>>>() {
                @Override
                public void onResponse(Call<BaseResponse<ArrayList<UserLoginObject>>> call, Response<BaseResponse<ArrayList<UserLoginObject>>> response) {
                    BaseResponse<ArrayList<UserLoginObject>> baseResponse = response.body();
                    assert baseResponse != null;
                    if (baseResponse.status_code == 200) {
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                }

                @Override
                public void onFailure(Call<BaseResponse<ArrayList<UserLoginObject>>> call, Throwable t) {
                    Toast.makeText(LoginActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
                    Log.e("Login failed", t.getMessage());
                }
            });


        });
    }
}