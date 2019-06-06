package com.buildmyapp.android.SignUp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.buildmyapp.android.BottomNavFragments.BottomNavigation;
import com.buildmyapp.android.R;

public class AddPhoto extends AppCompatActivity {

    CardView finishSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_photo);

        finishSignUp = (CardView) findViewById(R.id.cardView_add_photo);
        finishSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent toBottomNavigation = new Intent(AddPhoto.this, BottomNavigation.class);
                startActivity(toBottomNavigation);
            }
        });

    }
}
