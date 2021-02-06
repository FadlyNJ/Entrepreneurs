package com.fadly.entrepreneurs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {

    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent splash = new Intent(com.fadly.entrepreneurs.SplashScreen.this, com.fadly.entrepreneurs.MainActivity.class);
                startActivity(splash);
                finish();

            }
        },1000);
    }
}