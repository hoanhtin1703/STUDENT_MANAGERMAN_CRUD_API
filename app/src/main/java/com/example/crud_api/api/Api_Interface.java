package com.example.crud_api.api;

import com.example.crud_api.model.Account;
import com.example.crud_api.model.Student;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api_Interface {
    @POST("get_list.php")
    Call<List<Student>> getPets();

        @FormUrlEncoded
        @POST("and_student.php")
        Call<Student> insertStudent(
                @Field("key") String key,
                @Field("name") String name,
                @Field("student_code") String student_code,
                @Field("grade") String grade,
                @Field("major") String major,
                @Field("date") String date,
                @Field("image") String image);

        @FormUrlEncoded
@POST("update_student.php")
Call<Student> update_student(
        @Field("key") String key,
        @Field("id") int id,
        @Field("name") String name,
        @Field("student_code") String student_code,
        @Field("grade") String grade,
        @Field("major") String major,
        @Field("date") String date,
        @Field("image") String image);

//
//
        @FormUrlEncoded
        @POST("delete_student.php")
        Call<Student> delete_Student(
                @Field("key") String key,
                @Field("id") int id,
                @Field("image") String image);
//
        @FormUrlEncoded
        @POST("register.php")
        Call<Account> register(
                @Field("key") String key,
                @Field("user_name") String user_name,
                @Field("password") String password,
                @Field("name") String name);
    @FormUrlEncoded
    @POST("login.php")
    Call<Account> login(
            @Field("key") String key,
            @Field("user_name") String user_name,
            @Field("password") String password);



}
