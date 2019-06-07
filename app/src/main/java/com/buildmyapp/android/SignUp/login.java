package com.buildmyapp.android.SignUp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.buildmyapp.android.BottomNavFragments.BottomNavigation;
import com.buildmyapp.android.R;

public class login extends AppCompatActivity {


    private EditText name, password;
    private CardView loginButton;
    private int counter = 5;
    TextView registerText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        name = (EditText) findViewById(R.id.name_text);
        password= (EditText) findViewById(R.id.password_text);
        loginButton = (CardView) findViewById(R.id.cardView);
        registerText = (TextView)findViewById(R.id.textView_register);

        registerText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent createAccountIntent = new Intent(login.this, CreateAccount.class);
                startActivity(createAccountIntent);

            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(name.getText().toString(), password.getText().toString());
            }
        });
    }


    private void validate(String username, String userPassword){
        if((username.equals("Admin")) && (userPassword.equals("1234"))) {
            Intent intent = new Intent(login.this, BottomNavigation.class);
            startActivity(intent);
        }else{
            counter--;

            if (counter == 0){
                loginButton.setEnabled(false);
            }

        }

    }
}