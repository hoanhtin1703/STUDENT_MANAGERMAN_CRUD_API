package com.example.crud_api;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.crud_api.adapter.Api_Adapter;
import com.example.crud_api.api.ApiClient;
import com.example.crud_api.api.Api_Interface;
import com.example.crud_api.model.Account;
import com.example.crud_api.model.Student;
import com.google.android.material.snackbar.Snackbar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    CoordinatorLayout layout;
    private Api_Interface apiInterface;
    private EditText user_name,password,name,student_code,grade,major,date;
    private String muser_name,mpassword,mname,mstudent_code,mgrade,mmajor,mdate;
    Calendar myCalendar = Calendar.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Khởi tạo các View
//        getSupportActionBar().setTitle("Đăng ký tài khoản " );
        getSupportActionBar().hide();
        setContentView(R.layout.activity_register);
        user_name = findViewById(R.id.edt_user_name);
        password = findViewById(R.id.edt_password);
        name = findViewById(R.id.edt_user);
        student_code = findViewById(R.id.edt_student_code);
        grade = findViewById(R.id.edt_grade);
        major = findViewById(R.id.edt_major);
        date = findViewById(R.id.edt_date);
        Button btn_register = findViewById(R.id.btn_register);
        date.setFocusableInTouchMode(false);
        date.setFocusable(false);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(RegisterActivity.this, bdate, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        TextView click_here = findViewById(R.id.tv_click_here);

        click_here.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(user_name.getText().toString()) ||
                        TextUtils.isEmpty(password.getText().toString()) ||
                        TextUtils.isEmpty(name.getText().toString())
                         ){
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(RegisterActivity.this);
                    alertDialog.setMessage("Xin Mời Điền Đầy Đủ Hết Thông Tin!");
                    alertDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    alertDialog.show();
                }
                else {
                    muser_name = user_name.getText().toString().trim();
                    mpassword = password.getText().toString().trim();
                    mname = name.getText().toString().trim();
                    mstudent_code = student_code.getText().toString().trim();
                    mgrade = grade.getText().toString().trim();
                    mmajor = major.getText().toString().trim();
                    mdate = date.getText().toString().trim();

                    Register("register", muser_name, mpassword, mname,mstudent_code,mgrade,mmajor,mdate);
                }
            }
            public void Register(String key,String user,String pass,String name,String student_code,String grade,String major,String date){
// Gọi Api interface
                apiInterface = ApiClient.getApiClient().create(Api_Interface.class);
                // Gọi hàm call back
                Call<Account> call = apiInterface.register(key,user,pass,name,student_code,grade,major,date);
call.enqueue(new Callback<Account>() {
    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    public void onResponse(Call<Account> call, Response<Account> response) {
        Log.i(RegisterActivity.class.getSimpleName(), response.toString());
        String status = response.body().getStatus();
        String result_code = response.body().getResult_code();
        if(status.equals("true") && result_code.equals("0")){
           layout = findViewById(R.id.layout_id);
            Snackbar snackbar = Snackbar
                    .make(layout, "Đăng ký thành công", Snackbar.LENGTH_LONG);
            snackbar.show();

            InputMethodManager imm = (InputMethodManager)RegisterActivity.this.getSystemService(Activity.INPUT_METHOD_SERVICE); imm.hideSoftInputFromWindow(layout.getWindowToken(), 0);
           // Xây dựng hàm đợi (delay)
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent i = new Intent(RegisterActivity.this, LoginActivity.class);                        startActivity(i);
                }
            },1000);
        } else {
            Toast.makeText(RegisterActivity.this, "Tài Khoản Này Đã Được Sử Dụng Rồi ", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onFailure(Call<Account> call, Throwable t) {

    }
});
            }

        });

    }
    DatePickerDialog.OnDateSetListener bdate = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            setBirth();
        }
    };

    private void setBirth() {
        String myFormat = "dd MMMM yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        date.setText(sdf.format(myCalendar.getTime()));
    }

}



