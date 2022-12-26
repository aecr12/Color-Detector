package com.ae.colordetector;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.ae.Utils.FirebaseConnection;
import com.bumptech.glide.Glide;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class InternettenSecim extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.internetten_al);

        ImageView imageView = findViewById(R.id.imageView);
        Button tanimaButonu = findViewById(R.id.tanimaButonu);
        EditText editText = findViewById(R.id.editTextLink);
        imageView.setDrawingCacheEnabled(true);
        imageView.buildDrawingCache(true);
        TextView renkBilgiTextView = findViewById(R.id.renkBilgiTextView);
        TextView rgbBilgiTextView = findViewById(R.id.rgbBilgiTextView);
        TextView renkAdiTextView = findViewById(R.id.renkAdiTextView);
        FirebaseConnection firebaseConnection = new FirebaseConnection();
        firebaseConnection.getThread().start();

        tanimaButonu.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public void onClick(View view) {

                String link = editText.getText().toString();
                Glide.with(InternettenSecim.this).asBitmap().load(link).into(imageView);
                imageView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, @SuppressLint("ClickableViewAccessibility") MotionEvent motionEvent) {
                        Bitmap bitmap;
                        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN || motionEvent.getAction() == MotionEvent.ACTION_MOVE) {
                            bitmap = imageView.getDrawingCache();
                            int pixel = bitmap.getPixel((int) motionEvent.getX(), (int) motionEvent.getY());
                            int R = Color.red(pixel);
                            int G = Color.green(pixel);
                            int B = Color.blue(pixel);
                            String rHex = Integer.toHexString(R);
                            String gHex = Integer.toHexString(G);
                            String bHex = Integer.toHexString(B);
                            String hexKodu ="#"+ rHex + gHex + bHex;
                            //String hex = "#" + Integer.toHexString(pixel);
                            renkBilgiTextView.setText("HEX KODU: " + hexKodu);
                            rgbBilgiTextView.setText("R-G-B Değerleri: " + R + "-" + G + "-" + B);
                            for (int i = 0; i< firebaseConnection.getHexList().size(); i++){
                                if (hexKodu.equals(firebaseConnection.getHexList().get(i))){
                                    renkAdiTextView.setText("Renk Adı: "+firebaseConnection.getNameList().get(i));
                                }
                            }
                        }
                        return true;
                    }
                });
            }
        });
    }
}


