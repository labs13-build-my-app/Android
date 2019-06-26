package com.buildmyapp.android.Network;

import android.content.Context;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit = null;

    public static Retrofit getClient(Context context) {
        if (retrofit == null) {
            Retrofit.Builder builder = new Retrofit.Builder();
            builder.addConverterFactory(GsonConverterFactory.create());
            builder.baseUrl("https://build-my-app.herokuapp.com/");
            retrofit = builder.build();
        }
        return retrofit;
    }
}