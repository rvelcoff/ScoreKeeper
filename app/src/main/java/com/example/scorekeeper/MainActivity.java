package com.example.scorekeeper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchBaseball(View view){
        Intent baseballIntent = new Intent(this, BaseballActivity.class);
        startActivity(baseballIntent);
    }

    public void launchBasketball (View view){
        Intent basketballIntent = new Intent(this, BasketballActivity.class);
        startActivity(basketballIntent);
    }

    public void launchFootball (View view){
        Intent footballIntent = new Intent(this, FootballActivity.class);
        startActivity(footballIntent);
    }

    public void launchHockey (View view){
        Intent hockeyIntent = new Intent(this, HockeyActivity.class);
        startActivity(hockeyIntent);
    }

}