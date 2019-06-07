package com.buildmyapp.android.SignUp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import com.buildmyapp.android.R;

public class CreateAccount extends AppCompatActivity {

    CardView signUpContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account);

        signUpContinue = (CardView) findViewById(R.id.cardView_signup);

        signUpContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent toAddPhoto = new Intent(CreateAccount.this, AddPhoto.class);
                startActivity(toAddPhoto);
            }
        });

    }
}
