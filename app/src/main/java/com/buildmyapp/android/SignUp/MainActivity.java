package com.buildmyapp.android.SignUp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.buildmyapp.android.mainScreenActivity.AboutMobile;
import com.buildmyapp.android.R;
import com.buildmyapp.android.mainScreenActivity.aboutDev;

public class MainActivity extends AppCompatActivity {

    TextView signUpBtn;

    private EditText name, password;
    private int counter = 5;
    TextView registerText;
    CardView mobileCard, devCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mobileCard = (CardView) findViewById(R.id.mobile_card);
        devCard = (CardView) findViewById(R.id.dev_card);


        signUpBtn = findViewById(R.id.signup);

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent toSignUp = new Intent(MainActivity.this, Auth0_Login.class);
                startActivity(toSignUp);
            }
        });


        mobileCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent toAboutMobile = new Intent(MainActivity.this, AboutMobile.class);
                startActivity(toAboutMobile);
            }
        });

        devCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toAboutDev = new Intent(MainActivity.this, aboutDev.class);
                startActivity(toAboutDev);
            }
        });





    }
}