package com.example.a49nersense;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LocksActivity extends AppCompatActivity {

    private Button fdLK, fdULK, bdLK, bdULK, gdLK, gdULK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locks);
        fdLK = findViewById(R.id.fLock);
        fdULK = findViewById(R.id.fUnlock);
        bdLK = findViewById(R.id.backLock);
        bdULK = findViewById(R.id.backUnlock);
        gdLK = findViewById(R.id.gLock);
        gdULK = findViewById(R.id.gUnlock);

        setUpButtonListeners();
    }

    protected void setUpButtonListeners() {

        fdLK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String action = "frontDoorLock";
                String type = "update";
                BackgroundActivity backgroundActivity = new BackgroundActivity(LocksActivity.this);
                backgroundActivity.execute(type, action);
            }
        });

        fdULK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String action = "frontDoorUnlock";
                String type = "update";
                BackgroundActivity backgroundActivity = new BackgroundActivity(LocksActivity.this);
                backgroundActivity.execute(type, action);
            }
        });

        bdLK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String action = "backDoorLock";
                String type = "update";
                BackgroundActivity backgroundActivity = new BackgroundActivity(LocksActivity.this);
                backgroundActivity.execute(type, action);
            }
        });

        bdULK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String action = "backDoorUnlock";
                String type = "update";
                BackgroundActivity backgroundActivity = new BackgroundActivity(LocksActivity.this);
                backgroundActivity.execute(type, action);
            }
        });

        gdLK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String action = "garageDoorLock";
                String type = "update";
                BackgroundActivity backgroundActivity = new BackgroundActivity(LocksActivity.this);
                backgroundActivity.execute(type, action);
            }
        });

        gdULK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String action = "garageDoorUnlock";
                String type = "update";
                BackgroundActivity backgroundActivity = new BackgroundActivity(LocksActivity.this);
                backgroundActivity.execute(type, action);
            }
        });

    }
}
