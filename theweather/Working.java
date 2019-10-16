package com.example.tanzi.theweather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Working extends AppCompatActivity {
    private Button buttonRiddle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_working);

       // getSupportActionBar().setDisplayShowHomeEnabled(true);
       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        buttonRiddle = (Button) findViewById(R.id.buttonRiddleId);

        buttonRiddle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                openQuestion1();
            }

        });
    }
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if(id == android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
    public void openQuestion1(){
        Intent intentrid = new Intent(Working.this,RiddlePage.class);
        startActivity(intentrid);
    }
}
