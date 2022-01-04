package com.example.scorekeeper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class FootballActivity extends AppCompatActivity {

    int homeScore = 0;
    int awayScore = 0;
    int downCount = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.football_layout);

    }

    public void homeTouchdown (View view){
        homeScore = homeScore + 6;
        updateHomeScore(homeScore);
    }

    public void homePlusOne (View view){
        homeScore = homeScore + 1;
        updateHomeScore(homeScore);
    }

    public void homePlusTwo (View view){
        homeScore = homeScore + 2;
        updateHomeScore(homeScore);
    }

    public void homeFieldGoal (View view){
        homeScore = homeScore + 3;
        updateHomeScore(homeScore);
    }

    public void homeSafety (View view){
        homeScore = homeScore + 2;
        updateHomeScore(homeScore);
    }

    public void updateHomeScore (int score){
        TextView homeScoreTV = findViewById(R.id.home_score);
        homeScoreTV.setText("" + score);
    }

    public void awayTouchdown (View view){
        awayScore = awayScore + 6;
        updateAwayScore(awayScore);
    }

    public void awayPlusOne (View view){
        awayScore = awayScore + 1;
        updateAwayScore(awayScore);
    }

    public void awayPlusTwo (View view){
        awayScore = awayScore + 2;
        updateAwayScore(awayScore);
    }

    public void awayFieldGoal (View view){
        awayScore = awayScore + 3;
        updateAwayScore(awayScore);
    }

    public void awaySafety (View view){
        awayScore = awayScore + 2;
        updateAwayScore(awayScore);
    }

    public void updateAwayScore (int score){
        TextView awayScoreTV = findViewById(R.id.away_score);
        awayScoreTV.setText("" + score);
    }

    public void addDown (View view){
        TextView currentDown = findViewById(R.id.current_down);

        if (downCount < 4) {
            downCount = downCount + 1;
        } else if (downCount == 4){
            downCount = 1;
        }
        currentDown.setText("" + downCount);
    }

    public void resetScores(View view){
        homeScore = 0;
        awayScore = 0;
        updateHomeScore(homeScore);
        updateAwayScore(awayScore);
    }

    public void shareScores(View view) {
        String message = "The home team has " + homeScore + " points and the away team has " + awayScore + " points";
        Intent ourIntent = new Intent();
        ourIntent.setAction(Intent.ACTION_SEND);
        ourIntent.putExtra(Intent.EXTRA_TEXT, message);
        ourIntent.setType("text/plain");
        if (ourIntent.resolveActivity(getPackageManager()) != null) {

            startActivity(ourIntent);
        }
    }


}
