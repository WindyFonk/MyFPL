package com.example.myfpl.models;

public class UserLoginReq {
    public String username;
    public String pwd;

    public UserLoginReq(String usrnam, String pass) {
        this.username = usrnam;
        this.pwd = pass;
    }
}

