package com.kevmc.caloriecounter;

import android.content.Context;
import android.content.SharedPreferences;


/**
 * Class used to store and retrieve data from the app's shared preference storage
 * Works as key/pair values
 */

public class SharedPreferenceClass {

    //Object of SharedPreferences Class and SharedPreferences.Editor needed to access the app's
    //shared preference memory
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor editor;

    //Constants to ensure accurate insertion and retrieval
    protected static final String USER_DETAILS_PREFS_NAME = "USER_DETAILS_PREF";
    protected static final String USER_DETAILS_PREFS_KEY = "USER_PREFS_KEY";

    protected static final String USER_CRED_PREF_NAME = "USER_CRED_PREF";
    protected static final String USER_CRED_PREF_KEY = "USER_CRED_KEY";

    protected static final String PASS_CRED_PREF_NAME = "PASS_CRED_PREF";
    protected static final String PASS_CRED_PREF_KEY = "PASS_CRED_KEY";

    protected static final String DETAILS_PREF_NAME = "USER_NAME";
    protected static final String DETAILS_PREF_NAME_KEY = "USER_NAME_KEY";

    protected static final String DETAILS_PREF_AGE = "USER_AGE";
    protected static final String DETAILS_PREF_AGE_KEY = "USER_AGE_KEY";

    protected static final String DETAILS_PREF_HEIGHT = "USER_HEIGHT";
    protected static final String DETAILS_PREF_HEIGHT_KEY = "USER_HEIGHT_KEY";

    protected static final String DETAILS_PREF_WEIGHT = "USER_WEIGHT";
    protected static final String DETAILS_PREF_WEIGHT_KEY = "USER_WEIGHT_KEY";

    protected static final String DETAILS_PREF_GENDER = "USER_GENDER";
    protected static final String DETAILS_PREF_GENDER_KEY = "USER_GENDER_KEY";

    protected static final String DETAILS_PREF_ACTIVITY_LEVEL = "USER_ACTIVITY_LEVEL";
    protected static final String DETAILS_PREF_ACTIVITY_LEVEL_KEY = "USER_ACTIVITY_LEVEL_KEY";

    protected static final String TODAY_ALLOWANCE_SHARED_PREF_NAME = "USER_DAY_ALLOWANCE";
    protected static final String TODAY_ALLOWANCE_SHARED_PREF_KEY = "USER_DAY_ALLOWANCE_KEY";


    public SharedPreferenceClass(){
        super();
    }

    //Methods to save and access different values to different locations of shared preferences
    protected void saveUser(Context context, String text){

        mSharedPreferences = context.getSharedPreferences(USER_DETAILS_PREFS_NAME, Context.MODE_PRIVATE);
        editor = mSharedPreferences.edit();

        editor.putString(USER_DETAILS_PREFS_KEY, text);

        editor.commit();
    }

    protected String getUserObject(Context context){

        String text;

        mSharedPreferences = context.getSharedPreferences(USER_DETAILS_PREFS_NAME, Context.MODE_PRIVATE);

        text = mSharedPreferences.getString(USER_DETAILS_PREFS_KEY, null);

        return text;
    }

    protected void saveSharedPrefUsername (Context context, String username){

        mSharedPreferences = context.getSharedPreferences(USER_CRED_PREF_NAME, Context.MODE_PRIVATE);
        editor = mSharedPreferences.edit();

        editor.putString(USER_CRED_PREF_KEY, username);

        editor.commit();
    }

    protected String getSharedPrefUsername(Context context){

        //Type type = new TypeToken<List<UserLoginCredentials>>(){}.getType();
        mSharedPreferences = context.getSharedPreferences(USER_CRED_PREF_NAME, Context.MODE_PRIVATE);


        String usernameString = mSharedPreferences.getString(USER_CRED_PREF_KEY, "");

        //ArrayList<UserLoginCredentials> userLoginCredentialsList  = gson.fromJson(text, type);

        return usernameString;
    }

    protected void saveSharedPrefPassword(Context context, String password){

        mSharedPreferences = context.getSharedPreferences(PASS_CRED_PREF_NAME, Context.MODE_PRIVATE);
        editor = mSharedPreferences.edit();

        editor.putString(PASS_CRED_PREF_KEY, password);

        editor.commit();
    }

    protected String getSharedPrefPassword(Context context){

        mSharedPreferences = context.getSharedPreferences(PASS_CRED_PREF_NAME, Context.MODE_PRIVATE);

        String passwordString = mSharedPreferences.getString(PASS_CRED_PREF_KEY, "");

        return passwordString;
    }

    protected void saveSharedPrefName(Context context, String name){
        mSharedPreferences = context.getSharedPreferences(DETAILS_PREF_NAME, Context.MODE_PRIVATE);
        editor = mSharedPreferences.edit();
        editor.putString(DETAILS_PREF_NAME_KEY, name);
        editor.commit();
    }

    protected String getSharedPrefName(Context context){
        mSharedPreferences = context.getSharedPreferences(DETAILS_PREF_NAME, Context.MODE_PRIVATE);
        String name = mSharedPreferences.getString(DETAILS_PREF_NAME_KEY, "");
        return name;
    }

    protected void saveSharedPrefAge(Context context, int age){
        mSharedPreferences = context.getSharedPreferences(DETAILS_PREF_AGE, Context.MODE_PRIVATE);
        editor = mSharedPreferences.edit();
        editor.putInt(DETAILS_PREF_AGE_KEY, age);
        editor.commit();
    }

    protected int getSharedPrefAge(Context context){
        mSharedPreferences = context.getSharedPreferences(DETAILS_PREF_AGE, Context.MODE_PRIVATE);
        int age = mSharedPreferences.getInt(DETAILS_PREF_AGE_KEY, 0);
        return age;
    }

    protected void saveSharedPrefHeight(Context context, float height){
        mSharedPreferences = context.getSharedPreferences(DETAILS_PREF_HEIGHT, Context.MODE_PRIVATE);
        editor = mSharedPreferences.edit();
        editor.putFloat(DETAILS_PREF_HEIGHT_KEY, height);
        editor.commit();
    }

    protected float getSharedPrefHeight(Context context){
        mSharedPreferences = context.getSharedPreferences(DETAILS_PREF_HEIGHT, Context.MODE_PRIVATE);
        float height = mSharedPreferences.getFloat(DETAILS_PREF_HEIGHT_KEY, 0);
        return height;
    }

    protected void saveSharedPrefWeight(Context context, float weight){
        mSharedPreferences = context.getSharedPreferences(DETAILS_PREF_WEIGHT, Context.MODE_PRIVATE);
        editor = mSharedPreferences.edit();
        editor.putFloat(DETAILS_PREF_WEIGHT_KEY, weight);
        editor.commit();
    }

    protected float getSharedPrefWeight(Context context){
        mSharedPreferences = context.getSharedPreferences(DETAILS_PREF_WEIGHT, Context.MODE_PRIVATE);
        float weight = mSharedPreferences.getFloat(DETAILS_PREF_WEIGHT_KEY, 0);
        return weight;
    }

    protected void saveSharedPrefGender(Context context, boolean isMale){
        mSharedPreferences = context.getSharedPreferences(DETAILS_PREF_GENDER, Context.MODE_PRIVATE);
        editor = mSharedPreferences.edit();
        editor.putBoolean(DETAILS_PREF_GENDER_KEY, isMale);
        editor.commit();
    }

    protected boolean getSharedPrefGender(Context context){
        mSharedPreferences = context.getSharedPreferences(DETAILS_PREF_GENDER, Context.MODE_PRIVATE);
        boolean isMale = mSharedPreferences.getBoolean(DETAILS_PREF_GENDER_KEY, true);
        return isMale;
    }

    protected void saveSharedPrefActivityLevel(Context context, int activityLevel){
        mSharedPreferences = context.getSharedPreferences(DETAILS_PREF_ACTIVITY_LEVEL, Context.MODE_PRIVATE);
        editor = mSharedPreferences.edit();
        editor.putInt(DETAILS_PREF_ACTIVITY_LEVEL_KEY, activityLevel);
        editor.commit();
    }

    protected int getSharedPrefActivityLevel(Context context){
        mSharedPreferences = context.getSharedPreferences(DETAILS_PREF_ACTIVITY_LEVEL, Context.MODE_PRIVATE);
        int activityLevel = mSharedPreferences.getInt(DETAILS_PREF_ACTIVITY_LEVEL_KEY, 1);
        return activityLevel;
    }

    protected void saveSharedPrefTodayAllowance(Context context, float todayAllowance){
        mSharedPreferences = context.getSharedPreferences(TODAY_ALLOWANCE_SHARED_PREF_NAME, Context.MODE_PRIVATE);
        editor = mSharedPreferences.edit();
        editor.putFloat(TODAY_ALLOWANCE_SHARED_PREF_KEY, todayAllowance);
        editor.commit();
    }

    protected float getSharedPrefTodayAllowance(Context context){
        mSharedPreferences = context.getSharedPreferences(TODAY_ALLOWANCE_SHARED_PREF_NAME, Context.MODE_PRIVATE);
        float todayAllowance = mSharedPreferences.getFloat(TODAY_ALLOWANCE_SHARED_PREF_KEY, 1);
        return todayAllowance;
    }


}
