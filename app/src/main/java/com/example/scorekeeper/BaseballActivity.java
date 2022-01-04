package com.example.scorekeeper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BaseballActivity extends AppCompatActivity {
    int homeScore = 0;
    int awayScore = 0;
    int currentOuts = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.baseball_layout);
    }

    // Add one to the home team score
    public void homePlusOne (View view){
        homeScore = homeScore + 1;
        updateHomeScore(homeScore);
    }

    public void updateHomeScore(int score) {
        TextView homeScoreTV = findViewById(R.id.home_score);
        homeScoreTV.setText("" + score);
    }

    public void awayPlusOne (View view) {
        awayScore = awayScore + 1;
        updateAwayScore(awayScore);
    }

    public void updateAwayScore(int score){
        TextView awayScoreTV = findViewById(R.id.away_score);
        awayScoreTV.setText("" + score);
    }

    public void resetScores(View view){
        homeScore = 0;
        awayScore = 0;
        updateHomeScore(homeScore);
        updateAwayScore(awayScore);
    }

    public void addOut(View view){
        ImageView currentImage = findViewById(R.id.outs_image);
        if (currentOuts == 0){
            currentOuts = 1;
            currentImage.setImageResource(R.drawable.one_out);
        } else if (currentOuts == 1) {
            currentOuts = 2;
            currentImage.setImageResource(R.drawable.two_outs);
        } else if (currentOuts == 2) {
            currentOuts = 0;
            currentImage.setImageResource(R.drawable.no_outs);
        }

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
