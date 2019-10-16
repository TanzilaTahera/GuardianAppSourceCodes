package com.example.tanzi.theweather;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.Rating;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;

import java.util.ArrayList;

public class HomePage extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //quote and circle menu declarations
    public TextView quoteTextView;
    public ArrayList<Quote> quoteList;
    public int index;
    String arrayName[]={"weather1","weather2","weather3","weather4","weather5"};

    //quote and circle menu declarations end

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        quoteTextView = (TextView) findViewById(R.id.quote_text);

        //declaration for drawer code toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        // circle menu code starts
        CircleMenu circleMenu = (CircleMenu)findViewById(R.id.circle_menu);
        circleMenu.setMainMenu(Color.parseColor("#CDCDCD"),R.drawable.add_32,R.drawable.dart_board_32).
                addSubMenu(Color.parseColor("#258CFF"),R.drawable.sun).
                addSubMenu(Color.parseColor("#258CFF"),R.drawable.user_32).
                addSubMenu(Color.parseColor("#258CFF"),R.drawable.breakfast_32).
                addSubMenu(Color.parseColor("#258CFF"),R.drawable.running_man).
                addSubMenu(Color.parseColor("#258CFF"),R.drawable.thought_32).
                setOnMenuSelectedListener(new OnMenuSelectedListener(){

                    @Override
                    public void onMenuSelected (int index){
                        if(index==0) {
                             Toast.makeText(HomePage.this, "Weather Update", Toast.LENGTH_SHORT).show();
                            //Using intent to connect to another page
                            Intent intentWeather = new Intent(HomePage.this, MainActivity.class);
                            startActivity(intentWeather);
                        }
                        else if(index==1) {
                            Toast.makeText(HomePage.this, "Profile", Toast.LENGTH_SHORT).show();
                            Intent intentProf = new Intent(HomePage.this, userProfile.class);
                            startActivity(intentProf);
                        }
                        else if (index==2){
                            Toast.makeText(HomePage.this, "Meal Reminder", Toast.LENGTH_SHORT).show();
                            Intent intentMeal = new Intent(HomePage.this, AlrmHome.class);
                            startActivity(intentMeal);
                        }
                        else if(index==3){
                            Toast.makeText(HomePage.this, "Jogging Log", Toast.LENGTH_SHORT).show();
                            Intent intentJog = new Intent(HomePage.this,JoggingLog.class);
                            startActivity(intentJog);
                        }
                        else {
                            Toast.makeText(HomePage.this, "Riddle Time", Toast.LENGTH_SHORT).show();
                            Intent intentriddle = new Intent(HomePage.this,Working.class);
                            startActivity(intentriddle);
                        }

                    }

                });

        //circle menu code ends

        // import quotes from string.xml

        Resources res = getResources();
        String[] allQuotes = res.getStringArray(R.array.quotes);
        String[] allAuthors = res.getStringArray(R.array.authors);
        quoteList = new ArrayList<>();
        addToQuoteList(allQuotes,allAuthors);


        //generating random quotes from quotes

        final int quotesLength = quoteList.size();
        index= getRandomQuote(quotesLength-1);

        quoteTextView.setText(quoteList.get(index).toString());


        //quote code inside saved instance end
        //drawer code inside savedInstance starts

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    //adding all quotes to quoteList arrayList

    public void addToQuoteList(String[] allQuotes,String[] allAuthors){
        for(int i=0; i < allQuotes.length; i++){
            String quote = allQuotes[i];
            String author = allAuthors[i];
            Quote newQuote = new Quote(quote, author);
            quoteList.add(newQuote);

        }
    }

    public int getRandomQuote(int length){
        return (int) (Math.random() * length)+1;
    }

    //Quote code ends

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        //switch used for navbar connectivity to another activity
        switch(id){
            case R.id.nav_home:
                Intent navIntent = new Intent(HomePage.this,HomePage.class);
                startActivity(navIntent);
                break;
            case R.id.nav_profile:
                Intent navintent3 = new Intent(HomePage.this,userProfile.class);
                startActivity(navintent3);
                break;
            case R.id.nav_rating:
                Intent navIntent2 = new Intent(HomePage.this,RatingBar.class);
                startActivity(navIntent2);
                break;
            case R.id.nav_about:
                Intent navIntent4 = new Intent(HomePage.this,About.class);
                startActivity(navIntent4);
                break;
            case R.id.nav_logout:
                Intent navIntent5 = new Intent(HomePage.this, LoginActivity.class);
                startActivity(navIntent5);
                break;


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
