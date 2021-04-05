package com.example.myapplication.screens.payment.screensPayment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.myapplication.R;
import com.example.myapplication.screens.Home;
import com.example.myapplication.screens.SplashScreen;
import com.example.myapplication.screens.payment.SelectPayment;

public class Pix extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pix);

        ImageButton imgBtn = findViewById(R.id.cpyPix);
        ImageButton ret = findViewById(R.id.homeBtnPix);

        ret.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(Pix.this, Home.class));
            }
        });

        imgBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                setClipboard(getBaseContext(), "KSIFNVVYY24D0PKTV52789D0P0P");
            }
        });
    }

    private void setClipboard(Context context, String text) {
        if(android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.HONEYCOMB) {
            android.text.ClipboardManager clipboard = (android.text.ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
            clipboard.setText(text);
        } else {
            android.content.ClipboardManager clipboard = (android.content.ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
            android.content.ClipData clip = android.content.ClipData.newPlainText("Copied Pix", text);
            clipboard.setPrimaryClip(clip);
        }
    }
}