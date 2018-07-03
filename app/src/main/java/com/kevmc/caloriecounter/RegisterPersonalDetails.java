package com.kevmc.caloriecounter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class RegisterPersonalDetails extends AppCompatActivity {

    private TextView welcomeMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_personal_details);

        findViewsByIds();

        Intent intent = getIntent();
        Bundle bd = intent.getExtras();

        if(bd != null){
            String username = bd.getString("username");
            welcomeMessage.setText("Welcome "+username);
        }
    }

    private void findViewsByIds() {
        welcomeMessage = findViewById(R.id.register_persoanl_details_welcome_tv);
    }
}
