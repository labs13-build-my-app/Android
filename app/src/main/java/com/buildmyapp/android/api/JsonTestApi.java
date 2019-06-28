package com.buildmyapp.android.api;

import com.buildmyapp.android.model.Users;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonTestApi {

    @GET("api/users")
    Call<List<Users>> getJson();
}