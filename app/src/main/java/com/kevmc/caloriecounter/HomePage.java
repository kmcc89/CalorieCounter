package com.kevmc.caloriecounter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HomePage extends AppCompatActivity {

    private TextView welcomeTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        findViewsByIds();

        Intent intent = getIntent();
        Bundle bd = intent.getExtras();

        if(bd != null){
            String username = bd.getString("username");
            welcomeTv.setText("Welcome "+username);
        }
    }

    private void findViewsByIds() {
        welcomeTv = findViewById(R.id.home_welcome_tv);
    }


}
