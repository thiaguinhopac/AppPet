package com.example.myapplication.entities;

import android.app.Dialog;
import android.content.Context;
import android.widget.PopupWindow;

import com.example.myapplication.R;

public class PopUp {

    public static void show(Context context){
        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.activity_products);
        dialog.show();
    }
}
