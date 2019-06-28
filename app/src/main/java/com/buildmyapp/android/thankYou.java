package com.buildmyapp.android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.buildmyapp.android.BottomNavFragments.BottomNavigation;

public class thankYou extends AppCompatActivity {

    private Button goBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thank_you);


        goBack = (Button) findViewById(R.id.button3);


        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goBackBtn = new Intent(thankYou.this, BottomNavigation.class);
                startActivity(goBackBtn);
            }
        });
    }
}
