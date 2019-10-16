package com.example.tanzi.theweather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class RiddlePage extends AppCompatActivity {
    private riddleLibrary mQuestionLibrary = new riddleLibrary();
    private TextView mScoreView;
    private TextView mQuestionView;
    private Button mButtonChoice1;
    private Button quitButton;

    private String mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riddle_page);

       // getSupportActionBar().setDisplayShowHomeEnabled(true);
       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mQuestionView = (TextView)findViewById(R.id.question);
        mButtonChoice1 = (Button)findViewById(R.id.choice1);
        quitButton = (Button) findViewById(R.id.quit);


        updateQuestion();

        //Start of Button Listener for Button1
        mButtonChoice1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //My logic for Button goes in here

                Toast.makeText(RiddlePage.this,mAnswer, Toast.LENGTH_SHORT).show();
                if(mQuestionNumber == 10){ openResult();}
                updateQuestion();


            }
        });

        //End of Button Listener for Button1

        quitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent backToHomeIntent = new Intent(RiddlePage.this,HomePage.class);
                startActivity(backToHomeIntent);
            }

        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if(id == android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void updateQuestion(){
        // if( mQuestionNumber==30 ) openResult();
        mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
        // mButtonChoice1.setText(mQuestionLibrary.getChoice1(mQuestionNumber));


        mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);
        mQuestionNumber++;
    }
    private void openResult(){
        Intent resulIntent = new Intent(RiddlePage.this,Result.class);
        startActivity(resulIntent);
    }

}
