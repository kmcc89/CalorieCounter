package com.kevmc.caloriecounter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddFood extends AppCompatActivity {

    private Activity context = this;

    private Button addFoodBtn;

    private SharedPreferenceClass sharedPreferenceClass;

    private float calsConsumed = 500;
    private float allowance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);

        findViewsByIds();

        sharedPreferenceClass = new SharedPreferenceClass();

        allowance = sharedPreferenceClass.getSharedPrefTodayAllowance(this);

        addFoodBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                allowance = allowance - calsConsumed;

                sharedPreferenceClass.saveSharedPrefTodayAllowance(context, allowance);

                Intent home_intent = new Intent(AddFood.this, HomePage.class);
                startActivity(home_intent);
            }
        });


    }

    private void findViewsByIds() {
        addFoodBtn = findViewById(R.id.eat_food_btn);
    }
}
