package com.buildmyapp.android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class DevDetailsActivity extends AppCompatActivity {


    private ImageView profile;
    private AppCompatTextView name, desc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dev_details);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        profile = findViewById(R.id.profile);
        name = findViewById(R.id.name);
        desc = findViewById(R.id.description);


        desc.setText(getIntent().getStringExtra("desc"));
        name.setText(getIntent().getStringExtra("name"));

        try {
            Glide.with(this).load(getIntent().getStringExtra("profile")).into(profile);

        } catch (Exception e) {


        }

    }

}
