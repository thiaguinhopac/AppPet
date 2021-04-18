package com.example.myapplication.server;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static android.graphics.BitmapFactory.decodeByteArray;

public class LocalServer {

    final String localPath = "";



    public static void load2ram(Context context) {
        try {
            File file = new File(context.getFilesDir(), "DataServer.json");

            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;

                while ((line = br.readLine()) != null) {
                    parseToRam(line);
                }
                br.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
         catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void parseToRam(String line) throws JSONException {

        JSONObject jsonObject = new JSONObject("{" + line.substring(line.indexOf('{') + 1, line.length() - 2) + "}");

        Bitmap image = b64ToBitmap(jsonObject.getString("image"));
        String price = jsonObject.getString("price");
        String type = jsonObject.getString("type");
        String name = jsonObject.getString("name");
        String description = jsonObject.getString("description");

        Product.Photo.put(name,image);
        Product.description.put(name,description);
        Product.price.put(name,price);
        Product.type.put(name, type);

    }

    private static Bitmap b64ToBitmap(String str){
        byte[] decodedString = Base64.decode(str.toString(), Base64.DEFAULT);
        Bitmap decodedByte;
        decodedByte = decodeByteArray(decodedString, 0, decodedString.length);
        return decodedByte;
    }

}
