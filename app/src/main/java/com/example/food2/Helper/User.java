package com.example.food2.Helper;

public class User {
    public  String fullName,phone,age,email,password,c_password;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getC_password() {
        return c_password;
    }

    public void setC_password(String c_password) {
        this.c_password = c_password;
    }

    public User() {
    }

    public User(String fullName, String phone, String age, String email, String password, String c_password) {
        this.fullName = fullName;
        this.phone = phone;
        this.age = age;
        this.email = email;
        this.password = password;
        this.c_password = c_password;
    }

}
