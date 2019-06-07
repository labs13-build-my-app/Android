package com.buildmyapp.android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.buildmyapp.android.SignUp.CreateAccount;

public class AboutMobile extends AppCompatActivity {
    Button mobileToCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_mobile);

        mobileToCreate = (Button) findViewById(R.id.buttonSignUpMobile);

        mobileToCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mobileToCreate = new Intent(AboutMobile.this, CreateAccount.class);
                startActivity(mobileToCreate);
            }
        });
    }
}
