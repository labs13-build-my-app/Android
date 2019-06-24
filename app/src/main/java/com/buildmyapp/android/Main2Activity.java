package com.buildmyapp.android;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.buildmyapp.android.api.JsonDevApi;
import com.buildmyapp.android.model.Developer;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Main2Activity extends AppCompatActivity {

 TextView textViewDev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_connection);

        textViewDev = findViewById(R.id.text_view_dev);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://build-my-app.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonDevApi jsonDevApi = retrofit.create(JsonDevApi.class);

        Call<List<Developer>> call = jsonDevApi.getJson();

        call.enqueue(new Callback<List<Developer>>() {
            @Override
            public void onResponse(Call<List<Developer>> call, Response<List<Developer>> response) {

                if (!response.isSuccessful()) {
                    textViewDev.setText("Code: " + response.code());
                    return;
                }

                List<Developer> users = response.body();

                for (Developer user : users) {
                    String content = "";
                    content += "User name: " + user.getFirstName() + "\n";
                    content += "Password: " + user.getLastName() + "\n";
                    content += "Email: " + user.getEmail() + "\n";




                    textViewDev.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Developer>> call, Throwable t) {
                textViewDev.setText(t.getMessage());
            }
        });
    }


    }





















/** private static final String URL_DATA = "https://build-my-app.herokuapp.com/";


 private RecyclerView devRv;
 private RecyclerView.Adapter adapter;
 private List<Developer> developers;


 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_main2);

 devRv = (RecyclerView) findViewById(R.id.dev_row_rv_test);
 devRv.setHasFixedSize(true);
 devRv.setLayoutManager(new LinearLayoutManager(this));

 developers = new ArrayList<>();

 loadRecyclerViewData();
 }
 private void loadRecyclerViewData(){
 ProgressDialog progressDialog = new ProgressDialog (this);
 progressDialog.setMessage("Loading data...");
 progressDialog.show();

 StringRequest stringRequest = new StringRequest(Request.Method.GET,
 URL_DATA,
 new Response.Listener<String>() {
 @Override
 public void onResponse(String response) {
 try {
 JSONObject jsonObject = new JSONObject(response);
 JSONArray array = jsonObject.getJSONArray("Developer");

 for(int i = 0; i<array.length(); i++){
 JSONObject o = array.getJSONObject(i);
 Developer item = new Developer(
 o.getString("firstName"),o.getString("lastName"),o.getString("email"),o.getString("devType"),o.getString("skills"),
 o.getString("linkdIn"),o.getString("gitHub"),o.getString("twitter")
 ) ;
 developers.add(item);
 }
 adapter = new MyAdapter();

 } catch (JSONException e) {
 e.printStackTrace();
 }
 }
 },
 new Response.ErrorListener() {
 @Override
 public void onErrorResponse(VolleyError error) {

 }
 });

 RequestQueue requestQueue = Volley.newRequestQueue(this);
 requestQueue.add(stringRequest);
 }



 **/