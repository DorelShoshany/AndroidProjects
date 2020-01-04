package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


public class GameOver extends AppCompatActivity {

    private LinearLayout.LayoutParams buttonLayoutParams;
       // Write a message to the database

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        LinearLayout mainActivityLayout = findViewById(R.id.gameLayout);
        mainActivityLayout.setBackgroundResource(R.drawable.backgroundlogin);
        initParamsForButtons();
        createMainTitle();
        createYourPoints();
        createButtonHighScore();
        createStartNewGameButton();
    }




    public void initButtonStyle(Button button){
        button.setLayoutParams(buttonLayoutParams);
        button.setBackgroundResource(R.color.appColor);
        button.setGravity(Gravity.CENTER);
        button.setText(Global_Variable.START_NEW_GAME);
        button.setTextColor(getApplication().getResources().getColor(R.color.white));
    }

    public void initParamsForButtons(){
        //find size of all the screen:
        Point size = new Point();
        getWindowManager().getDefaultDisplay().getSize(size);
        int screenWidth = size.x;
        int screenHeight = size.y;

        int halfScreenWidth = (int)(screenWidth *0.5);
        int quarterScreenWidth = (int)(halfScreenWidth * 0.40);
        buttonLayoutParams =
                new LinearLayout.LayoutParams((int)(screenWidth *0.5),screenHeight/20);
        buttonLayoutParams.gravity = Gravity.CENTER;
        buttonLayoutParams.setMargins(0
                ,screenHeight/25
                ,0
                ,screenHeight/25);
    }

    public void createStartNewGameButton(){
        Button loginButton = new Button(this);
        initButtonStyle(loginButton);
        loginButton.setText(Global_Variable.START_NEW_GAME);
        loginButton.setTextColor(getApplication().getResources().getColor(R.color.white));
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNewGame();
            }
        });
        LinearLayout mainActivityLayout = findViewById(R.id.gameLayout);
        mainActivityLayout.addView(loginButton);
    }

    public void createButtonHighScore(){
        Button topHighScoreButton = new Button(this);
        initButtonStyle(topHighScoreButton);
        topHighScoreButton.setText(Global_Variable.TOP_NUMBER_TEXT_ON_BUTTON);
        topHighScoreButton.setTextColor(getApplication().getResources().getColor(R.color.white));
        topHighScoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openScoreSheetActivity();
            }
        });
        LinearLayout mainActivityLayout = findViewById(R.id.gameLayout);
        mainActivityLayout.addView(topHighScoreButton);
    }

    private void openScoreSheetActivity() {
        Intent myIntent = new Intent(GameOver.this, ScoreSheetActivity.class);
        finish();
        try {
            startActivity(myIntent);
        }catch (Exception e){
            e.getMessage();
        }
    }

    private void startNewGame(){
        Intent myIntent = new Intent(GameOver.this,
                GameActivity.class);
        GameActivity.myPoints=0 ;
        startActivity(myIntent);
    }

    void createMainTitle(){
        TextView titleText = new TextView(this);
        titleText.setText(Global_Variable.GAME_OVER);
        titleText.setTextColor(getResources().getColor(R.color.white));
        titleText.setTextSize(35);
        titleText.setGravity(Gravity.CENTER);
        titleText.setBackgroundResource(R.color.purple);
        LinearLayout mainActivityLayout = findViewById(R.id.gameLayout);
        mainActivityLayout.addView(titleText);
    }

    void createYourPoints(){
        TextView someText = new TextView(this);
        someText.setTextColor(getResources().getColor(R.color.white));
        someText.setTextSize(22);
        someText.setGravity(Gravity.CENTER);
        someText.setBackgroundResource(R.color.pink);
        LinearLayout mainActivityLayout = findViewById(R.id.gameLayout);
        mainActivityLayout.addView(someText);

        TextView yourPointsText = new TextView(this);
        int pointToPersent = GameActivity.myPoints;
        GameActivity.myPoints=0;
        yourPointsText.setText("You earn: "+ pointToPersent +" Points !");
        yourPointsText.setTextColor(getResources().getColor(R.color.white));
        yourPointsText.setTextSize(22);
        yourPointsText.setGravity(Gravity.CENTER);
        yourPointsText.setBackgroundResource(R.color.purple);
        mainActivityLayout.addView(yourPointsText);

    }


}
