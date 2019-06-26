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
    Button testBtn,testLogin, testDev;
    CardView signUpContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account);

        testBtn = (Button) findViewById(R.id.button);

        testLogin = (Button) findViewById(R.id.login_test);

        signUpContinue = (CardView) findViewById(R.id.cardView_signup);




        testBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent toTestConnection = new Intent(CreateAccount.this, TestConnection.class);
                startActivity(toTestConnection);
            }
        });

        testLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent toTestLogin = new Intent(CreateAccount.this, Auth0_Login.class);
                startActivity(toTestLogin);
            }
        });


    }
}
