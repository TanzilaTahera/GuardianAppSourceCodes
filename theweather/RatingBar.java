package com.example.tanzi.theweather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class RatingBar extends AppCompatActivity {
    android.widget.RatingBar ratingBar;
    Button buttonRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_bar);

        ratingBar = (android.widget.RatingBar) findViewById(R.id.ratingBarId);
        buttonRating = (Button) findViewById(R.id.buttonRateId);
        ratingBar.setMax(6);

        ratingBar.setOnRatingBarChangeListener(new android.widget.RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(android.widget.RatingBar ratingBar, float v, boolean b) {
                Toast.makeText(RatingBar.this, "Stars : "+v, Toast.LENGTH_SHORT).show();
            }
        });

        buttonRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(RatingBar.this, "Your rating :"+ratingBar.getRating(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}
