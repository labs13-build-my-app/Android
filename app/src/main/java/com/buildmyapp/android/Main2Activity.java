package com.buildmyapp.android;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.buildmyapp.android.model.Developer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

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
}