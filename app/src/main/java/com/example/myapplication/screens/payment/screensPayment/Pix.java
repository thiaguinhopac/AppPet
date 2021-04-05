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

public class Pix extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pix);

        ImageButton imgBtn = findViewById(R.id.cpyPix);
        ImageButton ret = findViewById(R.id.homeBtnPix);

        ret.setOnClickListener(view -> startActivity(new Intent(Pix.this, Home.class)));

        imgBtn.setOnClickListener(view -> setClipboard(getBaseContext()));
    }

    private void setClipboard(Context context) {
        ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("Copied Pix", "KSIFNVVYY24D0PKTV52789D0P0P");
        assert clipboard != null;
        clipboard.setPrimaryClip(clip);
    }
}