package com.buildmyapp.android.api;



import com.buildmyapp.android.model.model.developers.Developer;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonDevApi {

    @GET("api/Developer")
    Call<List<Developer>> getJson();
}