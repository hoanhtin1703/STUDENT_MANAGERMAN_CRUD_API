package com.example.crud_api;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.crud_api.api.ApiClient;
import com.example.crud_api.api.Api_Interface;
import com.example.crud_api.model.Account;
import com.example.crud_api.model.Student;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    CoordinatorLayout layout;

    private Api_Interface apiInterface;
    private EditText user_name,password;
    private String muser_name,mpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);


        user_name = findViewById(R.id.edt_user_name);
        password = findViewById(R.id.edt_password);
        Button btn_register = findViewById(R.id.btn_register_fromlogin);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
        Button btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                muser_name = user_name.getText().toString().trim();
                mpassword = password.getText().toString().trim();
                login("login",muser_name,mpassword);
            }
            public void login(final String key,final String user_name,final String pass) {
                apiInterface = ApiClient.getApiClient().create(Api_Interface.class);
                Call <Account> call = apiInterface.login(key,user_name,pass);
                call.enqueue(new Callback<Account>() {
                    @RequiresApi(api = Build.VERSION_CODES.P)
                    @Override
                    public void onResponse(Call<Account> call, Response<Account> response) {
                        Log.i(RegisterActivity.class.getSimpleName(), response.toString());
                        String status = response.body().getStatus();

//                        String name = response.body().getUser_name();
//                        String pass = response.body().getPassword();
                        Log.i("status",status);
//                        Log.i("name",name);
//                        Log.i("pass",pass);
                        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this);
                        progressDialog.setMessage("Đang đăng nhập...");
                        progressDialog.show();
                        if(status.equals("true")){
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    Intent i = new Intent(LoginActivity.this, MainActivity.class);                        startActivity(i);
                                }
                            },2000);
                            Toast.makeText(LoginActivity.this,"Đăng nhập thành công ",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(LoginActivity.this,"Đăng nhập thất bại ",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Account> call, Throwable t) {

                    }
                });
            }
        });
    }
}