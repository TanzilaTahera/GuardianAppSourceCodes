package com.example.tanzi.theweather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class AlrmHome extends AppCompatActivity {

    private Button buttonLunch,buttonDinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alrm_home);

        buttonLunch = (Button) findViewById(R.id.buttonLunch);
        buttonDinner = (Button) findViewById(R.id.buttonDinner);
       // progressBar = (ProgressBar) findViewById(R.id.progressBarId);

        //final RotatingCircle rotatingCircle = new RotatingCircle();
       // progressBar.setIndeterminateDrawable(rotatingCircle);

        buttonLunch.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

               // progressBar.setVisibility(View.VISIBLE);
                Intent intentLunch = new Intent(AlrmHome.this, mealReminder.class);
                startActivity(intentLunch);
               // progressBar.setVisibility(View.GONE);
            }
        });

        buttonDinner.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                // progressBar.setVisibility(View.VISIBLE);
                Intent intentLunch = new Intent(AlrmHome.this, mealReminder2.class);
                startActivity(intentLunch);
                // progressBar.setVisibility(View.GONE);
            }
        });
    }
}
