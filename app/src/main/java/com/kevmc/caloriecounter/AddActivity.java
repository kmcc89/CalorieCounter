package com.kevmc.caloriecounter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {

    private Activity context = this;

    private Button addActivityBtn;

    private SharedPreferenceClass sharedPreferenceClass;

    private float calsUsed = 500;
    private float allowance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        findViewsByIds();

        sharedPreferenceClass = new SharedPreferenceClass();

        allowance = sharedPreferenceClass.getSharedPrefTodayAllowance(this);

        addActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                allowance = allowance + calsUsed;

                sharedPreferenceClass.saveSharedPrefTodayAllowance(context, allowance);

                Intent home_intent = new Intent(AddActivity.this, HomePage.class);
                startActivity(home_intent);
                activityAddedToast();
                finish();
            }
        });
    }

    private void activityAddedToast() {
        Toast.makeText(this, "Activity added. Calorie allowance adjusted", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed(){
        Intent home_intent = new Intent(AddActivity.this, HomePage.class);
        startActivity(home_intent);
        finish();
    }

    private void findViewsByIds() {
        addActivityBtn = findViewById(R.id.use_energy_btn);
    }
}
