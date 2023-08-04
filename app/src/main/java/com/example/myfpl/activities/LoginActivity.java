package com.example.myfpl.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myfpl.R;
import com.example.myfpl.api.ServiceHelper;
import com.example.myfpl.models.BaseResponse;
import com.example.myfpl.models.UserLoginObject;
import com.example.myfpl.models.UserLoginReq;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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


        etEmail.setText("admin01");
        etPassword.setText("123456");
        btnLogin.setOnClickListener(view -> {
            UserLoginReq userReq = new UserLoginReq(etEmail.getText().toString(), etPassword.getText().toString());
            ServiceHelper.getInstance().login(userReq)
                    .enqueue(new Callback<BaseResponse<ArrayList<UserLoginObject>>>() {
                        @Override
                        public void onResponse(Call<BaseResponse<ArrayList<UserLoginObject>>> call, Response<BaseResponse<ArrayList<UserLoginObject>>> response) {
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                        }

                        @Override
                        public void onFailure(Call<BaseResponse<ArrayList<UserLoginObject>>> call, Throwable t) {
                            Log.e("LoginActivity", "onFailure: ", t);
                            Toast.makeText(LoginActivity.this, "Login Fail", Toast.LENGTH_SHORT).show();
                        }
                    });
        });
    }

}

