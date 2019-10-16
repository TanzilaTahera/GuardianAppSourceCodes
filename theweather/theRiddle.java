package com.example.tanzi.theweather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class theRiddle extends AppCompatActivity {
    private Button buttonRiddle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_riddle);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        buttonRiddle = (Button) findViewById(R.id.buttonRiddleId);

        buttonRiddle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                openQuestion1();
            }

        });
    }
    public void openQuestion1(){
        Intent intent = new Intent(this,RiddlePage.class);
        startActivity(intent);
    }
}
