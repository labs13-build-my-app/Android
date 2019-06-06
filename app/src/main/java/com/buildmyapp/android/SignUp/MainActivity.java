package com.buildmyapp.android.SignUp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.buildmyapp.android.BottomNavFragments.BottomNavigation;
import com.buildmyapp.android.R;

public class MainActivity extends AppCompatActivity {

    TextView signUpBtn;

    private EditText name, password;
    private int counter = 5;
    TextView registerText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signUpBtn = findViewById(R.id.signup);

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent toSignUp = new Intent(MainActivity.this, login.class);
                startActivity(toSignUp);
            }
        });


    }
}