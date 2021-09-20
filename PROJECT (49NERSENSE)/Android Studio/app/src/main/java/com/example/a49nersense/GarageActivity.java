package com.example.a49nersense;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class GarageActivity extends AppCompatActivity {

    private Button gOneopen, gOneclose, gTwoopen, gTwoclose;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garage);
        gTwoclose = findViewById(R.id.g2Close);
        gOneopen = findViewById(R.id.g1Open);
        gOneclose = findViewById(R.id.g1Close);
        gTwoopen = findViewById(R.id.g2Open);

        setUpButtonListeners();


    }

    protected void setUpButtonListeners() {

        gTwoclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String action = "garage2Close";
                String type = "update";
                BackgroundActivity backgroundActivity = new BackgroundActivity(GarageActivity.this);
                backgroundActivity.execute(type, action);
            }
        });

        gOneclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String action = "garage1Close";
                String type = "update";
                BackgroundActivity backgroundActivity = new BackgroundActivity(GarageActivity.this);
                backgroundActivity.execute(type, action);
            }
        });

        gTwoopen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String action = "garage2Open";
                String type = "update";
                BackgroundActivity backgroundActivity = new BackgroundActivity(GarageActivity.this);
                backgroundActivity.execute(type, action);
            }
        });

        gOneopen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String action = "garage1Open";
                String type = "update";
                BackgroundActivity backgroundActivity = new BackgroundActivity(GarageActivity.this);
                backgroundActivity.execute(type, action);
            }
        });


    }
}