package com.example.a49nersense;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextClock;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    private TextClock tClock;
    private ImageButton weatherButton, lockButton, cameraButton, secButton, tempButton, garageButton, lightsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tClock = findViewById(R.id.textClock);
        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        TextView textViewDate = findViewById(R.id.text_view_date);
        textViewDate.setText(currentDate);
        lightsButton = (ImageButton) findViewById(R.id.lightButton);
        secButton = (ImageButton) findViewById(R.id.securityButton);
        weatherButton = (ImageButton) findViewById(R.id.weatherButton);
        lockButton = (ImageButton) findViewById(R.id.lockButton);
        garageButton = (ImageButton) findViewById(R.id.garageButton);
        tempButton = (ImageButton) findViewById(R.id.temperatureButton);
        cameraButton = (ImageButton) findViewById(R.id.cameraButton);


        secButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openShieldActivity();
            }
        });

        lightsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLightActivity();
            }
        });

        weatherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWeatherActivity();
            }
        });

        lockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLocksActivity();
            }
        });

        garageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGarageActivity();
            }
        });

        tempButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTemperatureActivity();
            }
        });

        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCameraActivity();
            }
        });

    }


    public void openWeatherActivity() {
        Intent weatherIntent = new Intent(this, WeatherActivity.class);
        startActivity(weatherIntent);
    }

    public void openShieldActivity() {
        Intent shieldIntent = new Intent(this, ShieldActivity.class);
        startActivity(shieldIntent);
    }

    public void openCameraActivity() {
        Intent cameraIntent = new Intent(this, CameraActivity.class);
        startActivity(cameraIntent);
    }

    public void openTemperatureActivity() {
        Intent temperatureIntent = new Intent(this, TemperatureActivity.class);
        startActivity(temperatureIntent);
    }

    public void openLocksActivity() {
        Intent locksIntent = new Intent(this, LocksActivity.class);
        startActivity(locksIntent);
    }

    public void openGarageActivity(){
        Intent garageIntent = new Intent(this, GarageActivity.class);
        startActivity(garageIntent);
    }

    public void openLightActivity(){
        Intent lightIntent = new Intent (this, LightActivity.class);
        startActivity(lightIntent);
    }


}