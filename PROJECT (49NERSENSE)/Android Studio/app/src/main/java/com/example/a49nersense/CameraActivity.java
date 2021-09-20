package com.example.a49nersense;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CameraActivity  extends AppCompatActivity {

    private Button liveButton, storedButton;
    String streamURL="http://192.168.0.23:5000";
    WebView webView;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        webView=findViewById(R.id.webView);
        liveButton = findViewById(R.id.liveButton);

        liveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl(streamURL);
            }
        });


    }


}
