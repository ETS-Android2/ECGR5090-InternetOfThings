package com.example.a49nersense;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ShieldActivity extends AppCompatActivity {

    private Button away, home, disarm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shield);
        away = findViewById(R.id.button2);
        home = findViewById(R.id.button3);
        disarm = findViewById(R.id.button4);


        setUpButtonListeners();
    }

    protected void setUpButtonListeners() {

        away.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String action = "secArmedAway";
                String type = "update";
                BackgroundActivity backgroundActivity = new BackgroundActivity(ShieldActivity.this);
                backgroundActivity.execute(type, action);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String action = "secArmedHome";
                String type = "update";
                BackgroundActivity backgroundActivity = new BackgroundActivity(ShieldActivity.this);
                backgroundActivity.execute(type, action);
            }
        });

        disarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String action = "secDisarmed";
                String type = "update";
                BackgroundActivity backgroundActivity = new BackgroundActivity(ShieldActivity.this);
                backgroundActivity.execute(type, action);
            }
        });

    }
}