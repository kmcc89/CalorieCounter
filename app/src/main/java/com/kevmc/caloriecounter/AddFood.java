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

public class AddFood extends AppCompatActivity {

    private Activity context = this;

    private Button addFoodBtn;
    private EditText foodNameEt, foodCaloriesEt;

    private SharedPreferenceClass sharedPreferenceClass;

    private String name;
    private float calsConsumed;
    private float allowance;
    private int foodCounter;

    private String foodString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);

        findViewsByIds();

        sharedPreferenceClass = new SharedPreferenceClass();

        foodCounter = sharedPreferenceClass.getFoodCount(this);

        allowance = sharedPreferenceClass.getSharedPrefTodayAllowance(this);

        addFoodBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Date d = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
                String currentDateTimeString = sdf.format(d);

                name = foodNameEt.getText().toString();
                calsConsumed = Float.valueOf(foodCaloriesEt.getText().toString());
                allowance = allowance - calsConsumed;

                foodString = String.valueOf(foodCounter) + " " + currentDateTimeString + " " + name + " " +String.valueOf(calsConsumed);

                sharedPreferenceClass.saveFoodItem(context, foodString, foodCounter);

                foodCounter++;
                sharedPreferenceClass.saveFoodCount(context, foodCounter);

                sharedPreferenceClass.saveSharedPrefTodayAllowance(context, allowance);

                Intent home_intent = new Intent(AddFood.this, HomePage.class);
                startActivity(home_intent);
                foodAddedToast();
                finish();
            }
        });


    }

    private void foodAddedToast() {
        Toast.makeText(this, "Food added. Calorie Allowance adjusted", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed(){
        Intent home_intent = new Intent(AddFood.this, HomePage.class);
        startActivity(home_intent);
        finish();
    }

    private void findViewsByIds() {
        addFoodBtn = findViewById(R.id.eat_food_btn);
        foodCaloriesEt = findViewById(R.id.add_food_calories_et);
        foodNameEt = findViewById(R.id.add_food_name_et);
    }
}
