package com.buildmyapp.android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.buildmyapp.android.api.JsonTestApi;
import com.buildmyapp.android.model.Users;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TestConnection extends AppCompatActivity {
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_connection);

        textViewResult = findViewById(R.id.text_view_result);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://build-my-app.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonTestApi jsonTestApi = retrofit.create(JsonTestApi.class);

        Call<List<Users>> call = jsonTestApi.getJson();

        call.enqueue(new Callback<List<Users>>() {
            @Override
            public void onResponse(Call<List<Users>> call, Response<List<Users>> response) {

                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                List<Users> users = response.body();

                for (Users user : users) {
                    String content = "";
                    content += "ID: " + user.getId() + "\n";
                    content += "User name: " + user.getFirstName() + "\n";
                    content += "Password: " + user.getLastName() + "\n";
                    content += "Email: " + user.getEmail() + "\n";


                    textViewResult.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Users>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }
}