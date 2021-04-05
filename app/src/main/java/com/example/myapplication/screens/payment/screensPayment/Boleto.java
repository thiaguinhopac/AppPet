package com.example.myapplication.screens.payment.screensPayment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.myapplication.R;

public class Boleto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boleto);


        ImageButton btnBolDown = findViewById(R.id.BtnBolDown);

        btnBolDown.setOnClickListener(view -> com.example.myapplication.entities.Boleto.generateTicket());
    }
}