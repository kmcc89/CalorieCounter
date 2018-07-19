package com.kevmc.caloriecounter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DayBreakdown extends AppCompatActivity {

    private ListView mainListView;
    private ArrayAdapter<String> listAdapter;
    private ArrayList<String> foodList;

    private SharedPreferenceClass sharedPreferenceClass;

    private static int foodLoopCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_breakdown);

        mainListView = findViewById(R.id.mainListView);

        sharedPreferenceClass = new SharedPreferenceClass();
        foodList = new ArrayList<>();

        foodLoopCounter = sharedPreferenceClass.getFoodCount(this);

        for(int i = 1; i < foodLoopCounter; i++){
            foodList.add(sharedPreferenceClass.getFoodItem(this, i));
        }

        listAdapter = new ArrayAdapter<String>(this, R.layout.simplerow, foodList);

        mainListView.setAdapter(listAdapter);


    }

    public static void resetFoodCounter(){
        foodLoopCounter = 1;
    }

    @Override
    public void onBackPressed(){
        Intent home_intent = new Intent(DayBreakdown.this, HomePage.class);
        startActivity(home_intent);
        finish();
    }

}
