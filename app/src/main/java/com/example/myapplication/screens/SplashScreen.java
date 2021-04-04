package com.example.myapplication.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.example.myapplication.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        ProgressBar progressBar = (ProgressBar) findViewById(R.id.pb);
        Drawable draw = getDrawable(R.drawable.custom_progressbar);
// set the drawable as progress drawable
        progressBar.setProgressDrawable(draw);

        for (int x = 0; x < 70; x++){
            progressBar.setProgress(x);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}