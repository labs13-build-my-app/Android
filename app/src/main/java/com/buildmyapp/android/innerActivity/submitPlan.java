package com.buildmyapp.android.innerActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.buildmyapp.android.R;
import com.buildmyapp.android.thankYou;

public class submitPlan extends AppCompatActivity {

    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_plan);

        submit = findViewById(R.id.submit_plan);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent toThankyou = new Intent(submitPlan.this, thankYou.class);
                startActivity(toThankyou);
            }
        });
    }
}
