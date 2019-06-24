package com.buildmyapp.android.innerActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.buildmyapp.android.R;

public class bio extends AppCompatActivity {

    CardView sendMessege, askPlan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bio);

        sendMessege = (CardView) findViewById(R.id.message_cv);

        askPlan = (CardView) findViewById(R.id.message_plan);

        sendMessege.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent toMessege = new Intent(bio.this, MessageSeller.class);
                startActivity(toMessege);
            }
        });


    }
}
