package com.buildmyapp.android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ProjectDetailsActivity extends AppCompatActivity {


    private ImageView profile;
    private AppCompatTextView name, desc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_details);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        profile = findViewById(R.id.profile);
        name = findViewById(R.id.name);
        desc = findViewById(R.id.description);

        getIntent().getStringExtra("desc");
        desc.setText(getIntent().getStringExtra("desc"));
        name.setText(getIntent().getStringExtra("name"));

        try {
            Glide.with(this).load(getIntent().getStringExtra("profile")).into(profile);

        } catch (Exception e) {


        }


    }

}
