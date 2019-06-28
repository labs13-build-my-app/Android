package com.buildmyapp.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.buildmyapp.android.innerActivity.MessageSeller;
import com.bumptech.glide.Glide;

public class DevDetailsActivity extends AppCompatActivity {


    private ImageView profile;
    private AppCompatTextView name, desc;
    private Button sendMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dev_details);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        profile = findViewById(R.id.profile);
        name = findViewById(R.id.name);
        desc = findViewById(R.id.description);
        sendMessage = findViewById(R.id.messageDev);


        desc.setText(getIntent().getStringExtra("desc"));
        name.setText(getIntent().getStringExtra("name"));

        try {
            Glide.with(this).load(getIntent().getStringExtra("profile")).into(profile);

        } catch (Exception e) {


        }

        sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent messageDev = new Intent(DevDetailsActivity.this, MessageSeller.class);
                startActivity(messageDev);
            }
        });

    }

}
