package com.kevmc.caloriecounter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AddActivity extends AppCompatActivity {

    private Activity context = this;

    private Button addActivityBtn;
    private EditText actNameEt, actCaloriesEt;

    private SharedPreferenceClass sharedPreferenceClass;

    private float calsUsed;
    private float allowance;
    private String name;
    private int actCounter;

    private String activityString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        findViewsByIds();

        sharedPreferenceClass = new SharedPreferenceClass();

        actCounter = sharedPreferenceClass.getActCount(this);

        allowance = sharedPreferenceClass.getSharedPrefTodayAllowance(this);

        addActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Date d = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
                String currentDateTimeString = sdf.format(d);

                name = actNameEt.getText().toString();
                calsUsed = Float.valueOf(actCaloriesEt.getText().toString());
                allowance = allowance + calsUsed;

                activityString = String.valueOf(actCounter) + " " + currentDateTimeString + " " + name + " " +String.valueOf(calsUsed);

                sharedPreferenceClass.saveActivityItem(context, activityString, actCounter);

                actCounter++;
                sharedPreferenceClass.saveActCount(context, actCounter);

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
        addActivityBtn = findViewById(R.id.add_act_btn);
        actNameEt = findViewById(R.id.add_act_name_et);
        actCaloriesEt = findViewById(R.id.add_act_calories_et);
    }
}
