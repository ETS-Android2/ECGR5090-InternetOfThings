package com.example.a49nersense;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TemperatureActivity extends AppCompatActivity {

    private TextView cntrl1View, cntrl2View;
    private SeekBar t1SB, t2SB;
    private Button t1mode, t2mode, t1fan, t2fan;
    private EditText curntt1View, curntt2View;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);
        cntrl2View = (TextView) findViewById(R.id.control2Temp);
        cntrl1View = (TextView) findViewById(R.id.control1Temp);
        t1mode = (Button) findViewById(R.id.flr1mode);
        t2mode = (Button) findViewById(R.id.flr2mode);
        t1fan = (Button) findViewById(R.id.flr1Fan);
        t2fan = (Button) findViewById(R.id.flr2Fan);
        curntt1View = (EditText) findViewById(R.id.currentTemp);
        curntt2View = (EditText) findViewById(R.id.currentflr2Temp);
        t1SB  = (SeekBar) findViewById(R.id.cntrl1seekBar);
        t2SB  = (SeekBar) findViewById(R.id.cntrl2seekBar);


        setUpButtonListeners();
        setUpSeekButtonListeners();

    }

    protected void setUpButtonListeners() {

        t1mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String action = "";
                String type = "";
                BackgroundActivity backgroundActivity = new BackgroundActivity(TemperatureActivity.this);
                backgroundActivity.execute(type, action);
            }
        });

        t2mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String action = "";
                String type = "";
                BackgroundActivity backgroundActivity = new BackgroundActivity(TemperatureActivity.this);
                backgroundActivity.execute(type, action);
            }
        });

        t1fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String action = "";
                String type = "";
                BackgroundActivity backgroundActivity = new BackgroundActivity(TemperatureActivity.this);
                backgroundActivity.execute(type, action);
            }
        });

        t2fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String action = "";
                String type = "";
                BackgroundActivity backgroundActivity = new BackgroundActivity(TemperatureActivity.this);
                backgroundActivity.execute(type, action);
            }
        });

    }

    protected void setUpSeekButtonListeners(){

        t1SB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                cntrl1View.setText("" + progress + "C");
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        t2SB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                cntrl2View.setText("" + progress + "C");
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

    }

}