package com.example.myapplication.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.example.myapplication.Main;
import com.example.myapplication.R;
import com.example.myapplication.screens.payment.SelectPayment;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        ProgressBar progressBar = (ProgressBar) findViewById(R.id.pb);
        Drawable draw = getDrawable(R.drawable.custom_progressbar);
// set the drawable as progress drawable
        progressBar.setProgressDrawable(draw);

        for (int x = 0; x < 100; x++){
            progressBar.setProgress(x);
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        startActivity(new Intent(SplashScreen.this, SelectPayment.class));


    }
}