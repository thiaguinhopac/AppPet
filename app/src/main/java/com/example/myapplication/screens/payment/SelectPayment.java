package com.example.myapplication.screens.payment;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.myapplication.R;
import com.example.myapplication.entities.animations.Animate;
import com.example.myapplication.screens.SplashScreen;
import com.example.myapplication.screens.payment.screensPayment.Pix;

public class SelectPayment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_payment);



       // this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
         //       WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ImageView viewx = findViewById(R.id.dog);
        @SuppressLint("ResourceType") View l = findViewById(R.layout.activity_main);
        viewx.setVisibility(View.INVISIBLE);
        ImageButton bt = findViewById(R.id.cardBtn);
        ImageButton bt1 = findViewById(R.id.bolBtn);
        ImageButton bt2 = findViewById(R.id.pixBtn);

        final boolean[] b = {true};
                    Animate.slideUp(viewx, l);


        bt1.setOnClickListener(view -> startActivity(new Intent(SelectPayment.this, SplashScreen.class)));

        bt2.setOnClickListener(view -> startActivity(new Intent(SelectPayment.this, Pix.class)));
     //   requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
      //  getSupportActionBar().hide();


    }


}