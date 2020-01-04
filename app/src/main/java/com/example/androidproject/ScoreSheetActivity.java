package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ScoreSheetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_sheet);
        createMainTitle();
        LinearLayout mainActivityLayout = findViewById(R.id.gameLayout);
        mainActivityLayout.setBackgroundResource(R.drawable.backgroundlogin);
    }

    void createMainTitle(){
        TextView titleText = new TextView(this);
        titleText.setText(Global_Variable.TOP_10);
        titleText.setTextColor(getResources().getColor(R.color.white));
        titleText.setTextSize(35);
        titleText.setGravity(Gravity.CENTER);
        titleText.setBackgroundResource(R.color.purple);
        LinearLayout mainActivityLayout = findViewById(R.id.gameLayout);
        mainActivityLayout.addView(titleText);
    }




}
