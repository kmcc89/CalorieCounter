package com.kevmc.caloriecounter;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;

    private String sharedPrefUsername;

    private EditText mUsername, mPassword;
    private Button mSignInBtn, mRegisterBtn;
    private CheckBox mRememberDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViewsByIds();

        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mPreferences.edit();

        checkRememberLoginDetails();

        mSignInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                if(mRememberDetails.isChecked()){
                    mEditor.putString(getString(R.string.store_checkbox), "True");
                    mEditor.commit();

                    String name = mUsername.getText().toString();
                    mEditor.putString(getString(R.string.store_username), name);
                    mEditor.commit();

                    String password = mPassword.getText().toString();
                    mEditor.putString(getString(R.string.store_password), password);
                    mEditor.commit();

                }else{
                    //if user does not want to save
                    mEditor.putString(getString(R.string.store_checkbox), "False");
                    mEditor.commit();


                    mEditor.putString(getString(R.string.store_username), "");
                    mEditor.commit();


                    mEditor.putString(getString(R.string.store_password), "");
                    mEditor.commit();
                }
            }
        });
    }

    private void findViewsByIds() {

        mUsername = findViewById(R.id.login_username_et);
        mPassword = findViewById(R.id.login_password_et);
        mSignInBtn = findViewById(R.id.login_sign_in_btn);
        mRegisterBtn = findViewById(R.id.login_register_btn);
        mRememberDetails = findViewById(R.id.login_checkbox);
    }

    private void checkRememberLoginDetails(){

        String checkbox = mPreferences.getString(getString(R.string.store_checkbox), "False");
        String username = mPreferences.getString(getString(R.string.store_username), "");
        String password = mPreferences.getString(getString(R.string.store_password), "");

        mUsername.setText(username);
        mPassword.setText(password);

        if(checkbox.equals("True")){
            mRememberDetails.setChecked(true);
        }else{
            mRememberDetails.setChecked(false);
        }
    }
}
