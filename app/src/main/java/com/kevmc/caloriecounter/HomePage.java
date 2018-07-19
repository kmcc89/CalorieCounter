package com.kevmc.caloriecounter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomePage extends AppCompatActivity {

    /*
    *Activity object so we can pass context to the methods of SharedPreferenceClass
    *from inside anonymous onClick class
     */
    private Activity context = this;

    //TextView and Button references that will be mapped to XML layout elements
    private TextView welcomeTv, calorieAllowanceDisplay;
    private Button accountBtn, addFoodBtn, addActivityBtn, dayBreakdownBtn, recordsBtn, resourcesBtn, resetBtn;

    /*
    *Variables to assign values stored in SharedPreferences to.
    *Passed to User constructor to create object necessary for calculations
     */
    private String name;
    private int age, activityLevel;
    private float userHeight, userWeight;
    private boolean isMale;

    //Calorie allowance that will be assigned a value based on calculations made in User class
    //On subsequent logins for same day the value will come from app storage
    float todaysAllowance;

    //Object used to save and load values to/from the apps shared preferences
    private SharedPreferenceClass sharedPreferenceClass;
    private User user;

    private int flag = 0;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        //Get any data passed to the activity when started
        Intent incomingIntent = getIntent();
        Bundle bundle = incomingIntent.getExtras();

        //Method to map variables to XML elements
        findViewsByIds();

        //Instantiate SharedPrefClass object so methods can be called on it
        sharedPreferenceClass = new SharedPreferenceClass();

        //Call methods and assign returned values to variables
        name = sharedPreferenceClass.getSharedPrefName(this);
        age = sharedPreferenceClass.getSharedPrefAge(this);
        userHeight = sharedPreferenceClass.getSharedPrefHeight(this);
        userWeight = sharedPreferenceClass.getSharedPrefWeight(this);
        isMale = sharedPreferenceClass.getSharedPrefGender(this);
        activityLevel = sharedPreferenceClass.getSharedPrefActivityLevel(this);

        //Create user object with values retrieved from app's shared preferences
        user = new User(name, age, userHeight, userWeight, isMale, activityLevel);

        /*
        * Check if extra data was sent with intent when activity started.
        * A flag is passed with the intent when the user first registers their details so
        * When this activity is started from the login page and the register page a flag is sent
        * representing which activity started this one.  If it is from the login page the user's
        * previously stored value is loaded.  If it is from the register user activity a new value
        * is calculated for the daily allowance
         */
        if(bundle != null) {
            flag = bundle.getInt("flag");
        }

        user.calculateBMR();
        user.calculateTEE();

        if(flag == 1){
            todaysAllowance = user.getUserTEE();
        }else{
            todaysAllowance = sharedPreferenceClass.getSharedPrefTodayAllowance(this);
        }

        //Set user's name to screen
        welcomeTv.setText(name);

        //Display the current value for the user's calorie allowance
        calorieAllowanceDisplay.setText(String.valueOf(todaysAllowance));

        //Set action resulting from reset button being pressed
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Calculate values for user in case details have changed since last reset
                user.calculateBMR();
                user.calculateTEE();
                todaysAllowance = user.getUserTEE();
                //Save new allowance value and display it on screen
                sharedPreferenceClass.saveSharedPrefTodayAllowance(context, todaysAllowance);
                calorieAllowanceDisplay.setText(String.valueOf(todaysAllowance));

            }
        });


        //On click listeners for other buttons - redirect to other activities
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

        dayBreakdownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent breakdown_intent = new Intent(HomePage.this, DayBreakdown.class);
                startActivity(breakdown_intent);
            }
        });

        resourcesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resource_intent = new Intent(HomePage.this, ResourcesMain.class);
                startActivity(resource_intent);
            }
        });
    }

    //Map variables to XML elements using findViewById method
    private void findViewsByIds() {
        welcomeTv = findViewById(R.id.display_name_tv);
        calorieAllowanceDisplay = findViewById(R.id.display_cal_allowance_tv);
        accountBtn = findViewById(R.id.account_button);
        addFoodBtn = findViewById(R.id.add_food_btn);
        addActivityBtn = findViewById(R.id.add_activity_btn);
        resourcesBtn = findViewById(R.id.resources_button);
        resetBtn = findViewById(R.id.reset_and_log_button);
        dayBreakdownBtn = findViewById(R.id.day_breakdown_btn);
        recordsBtn = findViewById(R.id.records_btn);
    }

    //Menu to navigate app
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

            Intent calorie_counter = new Intent(HomePage.this, AddFood.class);
            startActivity(calorie_counter);

        }else if(id == R.id.food){

            Intent food_section = new Intent(HomePage.this, AddActivity.class);
            startActivity(food_section);

        }else if(id == R.id.activities){

            Intent activity_section = new Intent(HomePage.this, DayBreakdown.class);
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
