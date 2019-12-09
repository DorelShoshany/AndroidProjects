package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ActionBar;
import android.graphics.Point;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameActivity extends AppCompatActivity {

    private final String TAG = MainActivity.class.getSimpleName();
    List <Integer> hearts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        createLinearHeart();
        createPianoFall();

    }

    public ImageView createPiano(LinearLayout.LayoutParams params){
        ImageView piano = new ImageView(this);
        piano.setImageResource(R.drawable.piano);
        piano.setAdjustViewBounds(true);
        piano.setScaleType(ImageView.ScaleType.FIT_XY);
        piano.setLayoutParams(params);
        return piano;
    }

    public void createPianoFall(){

        //params for the size's piano:
        Point size = new Point();
        getWindowManager().getDefaultDisplay().getSize(size);
        int screenWidth = size.x;
        int screenHeight = size.y;
        int halfScreenWidth = (int)(screenWidth *0.15);
        int quarterScreenWidth = (int)(halfScreenWidth * 0.25);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(halfScreenWidth,LinearLayout.LayoutParams.MATCH_PARENT);

        LinearLayout screenLayout = new LinearLayout(this);
        screenLayout.setBackgroundResource(R.color.white);

        //TODO: for loop animator + random to x params + therades
        //TODO: function calculte the hearts that lefts
        ImageView piano = createPiano(params);

        screenLayout.addView(piano);

        LinearLayout mainActivityLayout = findViewById(R.id.gameLayout);
        mainActivityLayout.addView(screenLayout);
    }


    public void createLinearHeart(){
        Point size = new Point();
        getWindowManager().getDefaultDisplay().getSize(size);
        int screenWidth = size.x;
        int screenHeight = size.y;
        int halfScreenWidth = (int)(screenWidth *0.5);
        int quarterScreenWidth = (int)(halfScreenWidth * 0.25);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,quarterScreenWidth);
        LinearLayout linear_heart = new LinearLayout(this);
        linear_heart.setLayoutParams(params);
        linear_heart.setBackgroundResource(R.color.purple);
        linear_heart.setOrientation(LinearLayout.HORIZONTAL);

        //TODO: funtion that calculte the points
        TextView pointsText = new TextView(this);
        pointsText.setText("Points: 42");
        pointsText.setTextColor(getResources().getColor(R.color.white));
        pointsText.setTextSize(20);
        linear_heart.addView(pointsText);

        createHearts(linear_heart);
        createButtons(linear_heart);

        LinearLayout mainActivityLayout = findViewById(R.id.gameLayout);
        mainActivityLayout.addView(linear_heart);
    }


    //TODO: actiong to the button
    public void createButtons(LinearLayout linear_heart){
        LinearLayout.LayoutParams buttonLayoutParams =
                new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        buttonLayoutParams.gravity = Gravity.LEFT;
        buttonLayoutParams.setMargins(20,0,20,0);

        ImageButton exitButton = new ImageButton(this);
        ImageButton pauseButton = new ImageButton(this);
        ImageButton playButton = new ImageButton(this);

        exitButton.setImageResource(R.drawable.exit);
        exitButton.setBackgroundResource(R.color.purple);
        exitButton.setAdjustViewBounds(true);
        exitButton.setScaleType(ImageView.ScaleType.FIT_XY);
        exitButton.setLayoutParams(buttonLayoutParams);

        pauseButton.setImageResource(R.drawable.pouse);
        pauseButton.setBackgroundResource(R.color.purple);
        pauseButton.setAdjustViewBounds(true);
        pauseButton.setScaleType(ImageView.ScaleType.FIT_XY);
        pauseButton.setLayoutParams(buttonLayoutParams);

        playButton.setImageResource(R.drawable.play);
        playButton.setBackgroundResource(R.color.purple);
        playButton.setAdjustViewBounds(true);
        playButton.setScaleType(ImageView.ScaleType.FIT_XY);
        playButton.setLayoutParams(buttonLayoutParams);

        linear_heart.addView(exitButton);
        linear_heart.addView(pauseButton);
        linear_heart.addView(playButton);
    }


    public void createHearts (LinearLayout linear_heart){
        for (int i = 0 ; i< 3 ; i++) {
            hearts.add(i);
            ImageView heart = new ImageView(this);
            heart.setId(i);
            heart.setImageResource(R.drawable.heart);
            linear_heart.addView(heart, i);
            heart.setAdjustViewBounds(true);
            heart.setScaleType(ImageView.ScaleType.FIT_XY);
        }
    }
}
