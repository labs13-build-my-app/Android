package com.buildmyapp.android.model;

import org.json.JSONException;
import org.json.JSONObject;

public class Users {
    private long userid;
    private String username, password, email;

    public Users(){

    }

    public Users(JSONObject json){
        try {
            this.userid = json.getLong("1");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            this.username = json.getString("some name");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            this.email = json.getString("email");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
}