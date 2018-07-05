package com.kevmc.caloriecounter;

import android.app.Activity;
import android.content.Intent;
import android.print.PrinterId;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomePage extends AppCompatActivity {

    private Activity context = this;

    private TextView welcomeTv, calorieAllowanceDisplay;

    private Button accountBtn, addFoodBtn, addActivityBtn, foodBtn, activityBtn, resourcesBtn, resetBtn;

    private String name;
    private int age, activityLevel;
    private float userHeight, userWeight;
    private boolean isMale;

    float todaysAllowance;

    private SharedPreferenceClass sharedPreferenceClass;
    private User user;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        findViewsByIds();

        sharedPreferenceClass = new SharedPreferenceClass();

        name = sharedPreferenceClass.getSharedPrefName(this);
        age = sharedPreferenceClass.getSharedPrefAge(this);
        userHeight = sharedPreferenceClass.getSharedPrefHeight(this);
        userWeight = sharedPreferenceClass.getSharedPrefWeight(this);
        isMale = sharedPreferenceClass.getSharedPrefGender(this);
        activityLevel = sharedPreferenceClass.getSharedPrefActivityLevel(this);

        user = new User(name, age, userHeight, userWeight, isMale, activityLevel);

        todaysAllowance = sharedPreferenceClass.getSharedPrefTodayAllowance(this);

        user.calculateBMR();
        user.calculateTEE();

        if(todaysAllowance == 1){
            todaysAllowance = user.getUserTEE();
            sharedPreferenceClass.saveSharedPrefTodayAllowance(this, todaysAllowance);
        }

        welcomeTv.setText(name);
        calorieAllowanceDisplay.setText(String.valueOf(todaysAllowance));

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.calculateBMR();
                user.calculateTEE();
                todaysAllowance = user.getUserTEE();
                sharedPreferenceClass.saveSharedPrefTodayAllowance(context, todaysAllowance);
                calorieAllowanceDisplay.setText(String.valueOf(todaysAllowance));
            }
        });

        accountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent account_intent = new Intent(HomePage.this, UserAccount.class);
                startActivity(account_intent);
            }
        });

        addFoodBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent add_food_intent = new Intent(HomePage.this, AddFood.class);
                startActivity(add_food_intent);
            }
        });

        addActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent add_activity_intent = new Intent(HomePage.this, AddActivity.class);
                startActivity(add_activity_intent);
            }
        });
    }

    private void findViewsByIds() {
        welcomeTv = findViewById(R.id.display_name_tv);
        calorieAllowanceDisplay = findViewById(R.id.display_cal_allowance_tv);
        accountBtn = findViewById(R.id.account_button);
        addFoodBtn = findViewById(R.id.add_food_btn);
        addActivityBtn = findViewById(R.id.add_activity_btn);
        foodBtn = findViewById(R.id.food_button);
        //activityBtn = findViewById(R.id.activities_button);
        resourcesBtn = findViewById(R.id.resources_button);
        resetBtn = findViewById(R.id.reset_and_log_button);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public  boolean onOptionsItemSelected(MenuItem item){

        int id = item.getItemId();

        if(id == R.id.home){

            Intent home = new Intent(HomePage.this, HomePage.class);
            startActivity(home);

        }else if(id == R.id.calorie_counter){

            Intent calorie_counter = new Intent(HomePage.this, CalorieCounter.class);
            startActivity(calorie_counter);

        }else if(id == R.id.food){

            Intent food_section = new Intent(HomePage.this, FoodMain.class);
            startActivity(food_section);

        }else if(id == R.id.activities){

            Intent activity_section = new Intent(HomePage.this, ActivitiesMain.class);
            startActivity(activity_section);

        }else if(id == R.id.resources){

            Intent resource_section = new Intent(HomePage.this, ResourcesMain.class);
            startActivity(resource_section);

        }else if(id == R.id.exit){
            finish();
        }

        return super.onOptionsItemSelected(item);

    }


}
