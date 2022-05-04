package com.example.crud_api;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.crud_api.api.ApiClient;
import com.example.crud_api.api.Api_Interface;
import com.example.crud_api.model.Account;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private Api_Interface apiInterface; // Khởi tạo API_Interface
    private EditText user_name,password;
    private String muser_name,mpassword;
    private List<Account> studentlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Khởi tạo các View'
        getSupportActionBar().hide();
        user_name = findViewById(R.id.edt_user_name);
        password = findViewById(R.id.edt_password);
        TextView click_to_register = findViewById(R.id.click_to_register);
        click_to_register.setOnClickListener(new View.OnClickListener() {
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
                //Gọi Api
                apiInterface = ApiClient.getApiClient().create(Api_Interface.class);
                // Gọi hàm call back kêt nối với server theo phương thức login
                Call <Account> call = apiInterface.login(key,user_name,pass);
                call.enqueue(new Callback<Account>() {
                    @RequiresApi(api = Build.VERSION_CODES.P)
                    @Override
                    public void onResponse(Call<Account> call, Response<Account> response) {
                        Log.i(RegisterActivity.class.getSimpleName(), response.toString());
                        String status = response.body().getStatus();
                        int level = response.body().getLevel();
                        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this);
                        progressDialog.setMessage("Đang đăng nhập...");
                        progressDialog.show();
                        if(status.equals("true")){
                            if(level ==1 ){
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        Intent intent = new Intent(LoginActivity.this, Edit_API.class);
                                        intent.putExtra("id", response.body().getUser_id());
                                        intent.putExtra("name", response.body().getName());
                                        intent.putExtra("student_code", response.body().getStudent_code());
                                        intent.putExtra("grade", response.body().getGrade());
                                        intent.putExtra("major", response.body().getMajor());
                                        intent.putExtra("date", response.body().getDate());
                                        intent.putExtra("image", response.body().getImage());
                                        intent.putExtra("level",response.body().getLevel());
                                        intent.putExtra("account_id",response.body().getId());
                                        intent.putExtra("user_name",muser_name);
                                        intent.putExtra("password",mpassword);
                                        startActivity(intent);

                                    }
                                },2000);
                            }
                            else {
                                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                                startActivity(intent);
                            }
                            Toast.makeText(LoginActivity.this,"Đăng nhập thành công ",Toast.LENGTH_SHORT).show();
                        }

                        else {
                            progressDialog.dismiss();
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