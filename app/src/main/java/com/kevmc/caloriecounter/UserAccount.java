package com.kevmc.caloriecounter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserAccount extends AppCompatActivity {

    private TextView nameTv, ageTv, heightTv, weightTv, bmiTv, bmrTv, activityLevelTv, teeTv;

    private SharedPreferenceClass sharedPreferenceClass;

    private User user;
    private Button homeBtn, editBtn;

    private String name;
    private int age, activityLevel;
    private float userHeight, userWeight, bmi, bmr, tee;
    private boolean isMale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_account);

        findViewsByIds();

        sharedPreferenceClass = new SharedPreferenceClass();

        name = sharedPreferenceClass.getSharedPrefName(this);
        age = sharedPreferenceClass.getSharedPrefAge(this);
        userHeight = sharedPreferenceClass.getSharedPrefHeight(this);
        userWeight = sharedPreferenceClass.getSharedPrefWeight(this);
        isMale = sharedPreferenceClass.getSharedPrefGender(this);
        activityLevel = sharedPreferenceClass.getSharedPrefActivityLevel(this);

        user = new User(name, age, userHeight, userWeight, isMale, activityLevel);

        user.calculateBMI();
        user.calculateBMR();
        user.calculateTEE();

        bmi = user.getBodyMassIndex();
        bmr = user.getBasalMetabolicRate();
        tee = user.getUserTEE();

        setUserDetails();

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home_intent = new Intent(UserAccount.this, HomePage.class);
                startActivity(home_intent);
            }
        });

        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent edit_intent = new Intent(UserAccount.this, EditUserDetails.class);
                startActivity(edit_intent);
            }
        });


    }//ON CREATE METHOD

    private void findViewsByIds() {
        nameTv = findViewById(R.id.user_account_user_name_tv);
        ageTv = findViewById(R.id.user_account_user_age_tv);
        heightTv = findViewById(R.id.user_account_user_height_tv);
        weightTv = findViewById(R.id.user_account_user_weight_tv);
        bmiTv = findViewById(R.id.user_account_user_bmi_tv);
        bmrTv = findViewById(R.id.user_account_user_bmr_tv);
        activityLevelTv = findViewById(R.id.user_account_user_activity_level_tv);
        teeTv = findViewById(R.id.user_account_user_tee_tv);
        homeBtn = findViewById(R.id.home_btn);
        editBtn = findViewById(R.id.edit_details_btn);
    }

    private void setUserDetails(){
        nameTv.setText(name);
        ageTv.setText(String.valueOf(age));
        heightTv.setText(String.valueOf(userHeight));
        weightTv.setText(String.valueOf(userWeight));
        bmiTv.setText(String.valueOf(bmi));
        bmrTv.setText(String.valueOf(bmr));
        activityLevelTv.setText(String.valueOf(activityLevel));
        teeTv.setText(String.valueOf(tee));
    }
}
