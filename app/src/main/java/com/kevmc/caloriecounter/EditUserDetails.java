package com.kevmc.caloriecounter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditUserDetails extends AppCompatActivity {

    Activity context = this;

    private EditText nameEt, ageEt, heightEt, weightET, activityLevelEt;

    private SharedPreferenceClass sharedPreferenceClass;

    private String name;
    private int age, activityLevel;
    float height, weight;

    private Button confirmEditBtn;

    private int flag = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user_details);

        findViewsByIds();

        sharedPreferenceClass = new SharedPreferenceClass();

        name = sharedPreferenceClass.getSharedPrefName(this);
        age = sharedPreferenceClass.getSharedPrefAge(this);
        height = sharedPreferenceClass.getSharedPrefHeight(this);
        weight = sharedPreferenceClass.getSharedPrefWeight(this);
        activityLevel = sharedPreferenceClass.getSharedPrefActivityLevel(this);

        nameEt.setText(name);
        ageEt.setText(String.valueOf(age));
        heightEt.setText(String.valueOf(height));
        weightET.setText(String.valueOf(weight));
        activityLevelEt.setText(String.valueOf(activityLevel));

        confirmEditBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name = nameEt.getText().toString();
                age = Integer.valueOf(ageEt.getText().toString());
                height = Float.valueOf(heightEt.getText().toString());
                weight = Float.valueOf(weightET.getText().toString());
                activityLevel = Integer.valueOf(activityLevelEt.getText().toString());

                sharedPreferenceClass.saveSharedPrefName(context, name);
                sharedPreferenceClass.saveSharedPrefAge(context, age);
                sharedPreferenceClass.saveSharedPrefHeight(context, height);
                sharedPreferenceClass.saveSharedPrefWeight(context, weight);
                sharedPreferenceClass.saveSharedPrefActivityLevel(context, activityLevel);

                detailsEditedToast();

                Intent home_intent = new Intent(EditUserDetails.this, HomePage.class);
                home_intent.putExtra("flag", flag);
                startActivity(home_intent);
                finish();
            }
        });

    }

    private void detailsEditedToast() {
        Toast.makeText(this, "Personal Details Saved", Toast.LENGTH_SHORT).show();
    }

    private void findViewsByIds() {
        nameEt = findViewById(R.id.user_edit_name_et);
        ageEt = findViewById(R.id.user_edit_age_et);
        heightEt = findViewById(R.id.user_edit_height_et);
        weightET = findViewById(R.id.user_edit_weight_et);
        activityLevelEt = findViewById(R.id.user_edit_activity_level_et);
        confirmEditBtn = findViewById(R.id.user_edit_button);
    }
}
