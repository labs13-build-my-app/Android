package com.buildmyapp.android.SignUp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;

import com.buildmyapp.android.R;
import com.buildmyapp.android.TestConnection;

public class CreateAccount extends AppCompatActivity {
    Button testBtn;
    CardView signUpContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account);

        testBtn = (Button) findViewById(R.id.button);

        signUpContinue = (CardView) findViewById(R.id.cardView_signup);

        signUpContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent toAddPhoto = new Intent(CreateAccount.this, AddPhoto.class);
                startActivity(toAddPhoto);
            }
        });

        testBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent toTestConnection = new Intent(CreateAccount.this, TestConnection.class);
                startActivity(toTestConnection);
            }
        });

    }
}
