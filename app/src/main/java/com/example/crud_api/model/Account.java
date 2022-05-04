package com.example.crud_api.model;

import com.google.gson.annotations.SerializedName;

public class Account {
    @SerializedName("id")
    private int id;
    @SerializedName("user_name")
    private String user_name;
    @SerializedName("password")
    private String 	password;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @SerializedName("level")
    private int level;
    @SerializedName("user_id")
    private int user_id;
    @SerializedName("name")
    private String name;
    @SerializedName("student_code")
    private String 	student_code;
    @SerializedName("grade")
    private String 	grade;
    @SerializedName("major")
    private String major;
    @SerializedName("date")
    private String date;
    @SerializedName("image")
    private String image;
    @SerializedName("status")
    private String 	status;
    @SerializedName("result_code")
    private String 	result_code;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudent_code() {
        return student_code;
    }

    public void setStudent_code(String student_code) {
        this.student_code = student_code;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResult_code() {
        return result_code;
    }

    public void setResult_code(String result_code) {
        this.result_code = result_code;
    }
}
