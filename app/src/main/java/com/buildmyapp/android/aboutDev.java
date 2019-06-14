package com.buildmyapp.android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.buildmyapp.android.R;
import com.buildmyapp.android.SignUp.CreateAccount;

public class aboutDev extends AppCompatActivity {

    Button fromDevToCreat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_dev);

        fromDevToCreat = (Button) findViewById(R.id.buttonSignUpDev);

        fromDevToCreat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent devToCreate = new Intent(aboutDev.this, CreateAccount.class);
                startActivity(devToCreate);
            }
        });
    }
}
