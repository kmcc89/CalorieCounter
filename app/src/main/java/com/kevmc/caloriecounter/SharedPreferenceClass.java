package com.kevmc.caloriecounter;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevmc on 02/07/2018.
 */

public class SharedPreferenceClass {

    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor editor;

    public static final String USER_DETAILS_PREFS_NAME = "USER_DETAILS_PREF";
    public static final String USER_DETAILS_PREFS_KEY = "USER_PREFS_KEY";

    public static final String USER_CRED_PREF_NAME = "USER_CRED_PREF";
    public static final String USER_CRED_PREF_KEY = "USER_CRED_KEY";
    public static final String PASS_CRED_PREF_NAME = "PASS_CRED_PREF";
    public static final String PASS_CRED_PREF_KEY = "PASS_CRED_KEY";


    public SharedPreferenceClass(){
        super();
    }

    public void saveUser(Context context, String text){

        mSharedPreferences = context.getSharedPreferences(USER_DETAILS_PREFS_NAME, Context.MODE_PRIVATE);
        editor = mSharedPreferences.edit();

        editor.putString(USER_DETAILS_PREFS_KEY, text);

        editor.commit();
    }

    public String getUserObject(Context context){

        String text;

        mSharedPreferences = context.getSharedPreferences(USER_DETAILS_PREFS_NAME, Context.MODE_PRIVATE);

        text = mSharedPreferences.getString(USER_DETAILS_PREFS_KEY, null);

        return text;
    }

    public void saveSharedPrefUsername (Context context, String username){

        mSharedPreferences = context.getSharedPreferences(USER_CRED_PREF_NAME, Context.MODE_PRIVATE);
        editor = mSharedPreferences.edit();

        editor.putString(USER_CRED_PREF_KEY, username);

        editor.commit();
    }

    public String getSharedPrefUsername(Context context){

        //Type type = new TypeToken<List<UserLoginCredentials>>(){}.getType();
        mSharedPreferences = context.getSharedPreferences(USER_CRED_PREF_NAME, Context.MODE_PRIVATE);


        String usernameString = mSharedPreferences.getString(USER_CRED_PREF_KEY, "");

        //ArrayList<UserLoginCredentials> userLoginCredentialsList  = gson.fromJson(text, type);

        return usernameString;
    }

    public void saveSharedPrefPassword(Context context, String password){

        mSharedPreferences = context.getSharedPreferences(PASS_CRED_PREF_NAME, Context.MODE_PRIVATE);
        editor = mSharedPreferences.edit();

        editor.putString(PASS_CRED_PREF_KEY, password);

        editor.commit();
    }

    public String getSharedPrefPassword(Context context){

        mSharedPreferences = context.getSharedPreferences(PASS_CRED_PREF_NAME, Context.MODE_PRIVATE);

        String passwordString = mSharedPreferences.getString(PASS_CRED_PREF_KEY, "");

        return passwordString;
    }


}
