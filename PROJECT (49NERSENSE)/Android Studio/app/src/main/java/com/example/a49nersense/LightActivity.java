package com.example.a49nersense;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LightActivity extends AppCompatActivity {

    private Button lit;
    private SeekBar flr1Lit, flr2Lit;
    private TextView litLvl1View, litLvl2View;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light);
        lit = (Button) findViewById(R.id.lit);
        flr1Lit   = (SeekBar) findViewById(R.id.cntrl2seekBar);
        flr2Lit = (SeekBar) findViewById(R.id.l2seekBar);
        litLvl1View = (TextView) findViewById(R.id.flr1Light);
        litLvl2View = (TextView) findViewById(R.id.flr2Light);

        setUpButtonListeners();
        setUpSeekButtonListeners();
    }

    protected void setUpButtonListeners() {

        lit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String action = "";
                String type = "";
                BackgroundActivity backgroundActivity = new BackgroundActivity(LightActivity.this);
                backgroundActivity.execute(type, action);
            }
        });
    }

    protected void setUpSeekButtonListeners(){

        flr1Lit.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                litLvl1View.setText("" + progress + "%");
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        flr2Lit.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                litLvl2View.setText("" + progress + "%");
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
