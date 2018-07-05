package com.kevmc.caloriecounter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ResourcesMain extends AppCompatActivity {

    Spanned tx1, tx2, tx3, tx4, tx5, tx6, tx7, tx8, tx9, tx10;
    TextView hyperLink1, hyperLink2, hyperLink3, hyperLink4, hyperLink5, hyperLink6, hyperLink7, hyperLink8, hyperLink9, hyperLink10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resources_main);

        hyperLink1 = (TextView)findViewById(R.id.resourceLink1);
        tx1 = Html.fromHtml(getString(R.string.Resource_Link_BBC_GoodFood)+
                getString(R.string.Resource_Link_Description_BBC_GoodFood));
        hyperLink1.setMovementMethod(LinkMovementMethod.getInstance());
        hyperLink1.setText(tx1);

        hyperLink2 = (TextView)findViewById(R.id.resourceLink2);
        tx2 = Html.fromHtml(getString(R.string.Resource_Link_Nutrition_gov)+
                getString(R.string.Resource_Link__Description_Nutrition_gov));
        hyperLink2.setMovementMethod(LinkMovementMethod.getInstance());
        hyperLink2.setText(tx2);

        hyperLink3 = (TextView)findViewById(R.id.resourceLink3);
        tx3 = Html.fromHtml(getString(R.string.Resource_Link_MyFitnessPal_Food_Database)+
                getString(R.string.Resource_Link_Description_MyFitnessPal_Food_Database));
        hyperLink3.setMovementMethod(LinkMovementMethod.getInstance());
        hyperLink3.setText(tx3);

        hyperLink4 = (TextView)findViewById(R.id.resourceLink4);
        tx4 = Html.fromHtml(getString(R.string.Resource_Link_BordBia)+
                getString(R.string.Resource_Link_Description_BordBia));
        hyperLink4.setMovementMethod(LinkMovementMethod.getInstance());
        hyperLink4.setText(tx4);

        hyperLink5 = (TextView)findViewById(R.id.resourceLink5);
        tx5 = Html.fromHtml(getString(R.string.Resource_Link_World_Health_Organisation)+
                getString(R.string.Resource_Link_Description_World_Health_Organisation));
        hyperLink5.setMovementMethod(LinkMovementMethod.getInstance());
        hyperLink5.setText(tx5);

        hyperLink6 = (TextView)findViewById(R.id.resourceLink6);
        tx6 = Html.fromHtml(getString(R.string.Resource_Link_Health_ie)+
                getString(R.string.Resource_Link_Description_Health_ie));
        hyperLink6.setMovementMethod(LinkMovementMethod.getInstance());
        hyperLink6.setText(tx6);

        hyperLink7 = (TextView)findViewById(R.id.resourceLink7);
        tx7 = Html.fromHtml(getString(R.string.Resource_Link_Health_Status_Energy_Expend_Calculator)+
                getString(R.string.Resource_Link_Description_Health_Status_Energy_Expend_Calculator));
        hyperLink7.setMovementMethod(LinkMovementMethod.getInstance());
        hyperLink7.setText(tx7);

        hyperLink8 = (TextView)findViewById(R.id.resourceLink8);
        tx8 = Html.fromHtml(getString(R.string.Resource_Link_BMI_Calculator)+
                getString(R.string.Resource_Link_Description_BMI_Calculator));
        hyperLink8.setMovementMethod(LinkMovementMethod.getInstance());
        hyperLink8.setText(tx8);

        hyperLink9 = (TextView)findViewById(R.id.resourceLink9);
        tx9 = Html.fromHtml(getString(R.string.Resource_Link_BMR_Calculator)+
                getString(R.string.Resource_Link_Description_BMR_Calculator));
        hyperLink9.setMovementMethod(LinkMovementMethod.getInstance());
        hyperLink9.setText(tx9);

        hyperLink10 = (TextView)findViewById(R.id.resourceLink10);
        tx10 = Html.fromHtml(getString(R.string.Resource_Link_FitDay_Fitness_Components)+
                getString(R.string.Resource_Link_Description_FitDay_Fitness_Components));
        hyperLink10.setMovementMethod(LinkMovementMethod.getInstance());
        hyperLink10.setText(tx10);
    }

    @Override
    public void onBackPressed(){
        Intent home_intent = new Intent(ResourcesMain.this, HomePage.class);
        startActivity(home_intent);
        finish();
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

            Intent home = new Intent(ResourcesMain.this, HomePage.class);
            startActivity(home);

        }else if(id == R.id.calorie_counter){

            Intent calorie_counter = new Intent(ResourcesMain.this, CalorieCounter.class);
            startActivity(calorie_counter);

        }else if(id == R.id.food){

            Intent food_section = new Intent(ResourcesMain.this, FoodMain.class);
            startActivity(food_section);

        }else if(id == R.id.activities){

            Intent activity_section = new Intent(ResourcesMain.this, ActivitiesMain.class);
            startActivity(activity_section);

        }else if(id == R.id.resources){

            Intent resource_section = new Intent(ResourcesMain.this, ResourcesMain.class);
            startActivity(resource_section);

        }else if(id == R.id.exit){
            finish();
        }

        return super.onOptionsItemSelected(item);

    }
}
