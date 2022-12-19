package com.ae.colordetector;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.ae.Utils.FirebaseConnection;

public class DosyalardanSecim extends AppCompatActivity{

    Intent intent;
    ImageView imageView2;
    int SELECT_PICTURE = 200;

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_PICTURE) {
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    imageView2.setImageURI(selectedImageUri);
                }
            }
        }
    }
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dosyalardan_al);

        Button getirmeButonu = findViewById(R.id.getirmeButonu);
        imageView2 = findViewById(R.id.imageView2);
        TextView renkBilgiTextView2 = findViewById(R.id.renkBilgiTextView2);
        TextView rgbBilgiTextView2 = findViewById(R.id.rgbBilgiTextView2);
        TextView renkAdiTextView2 = findViewById(R.id.renkAdiTextView2);

        FirebaseConnection firebaseConnection = new FirebaseConnection();
        firebaseConnection.getThread().start();

        getirmeButonu.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public void onClick(View view) {
                intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_PICTURE);
            }
        });

        imageView2.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Bitmap bitmap;
                imageView2.setDrawingCacheEnabled(true);
                bitmap = imageView2.getDrawingCache();
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN || motionEvent.getAction() == MotionEvent.ACTION_MOVE) {
                    int pixel = bitmap.getPixel((int) motionEvent.getX(), (int) motionEvent.getY());
                    int R = Color.red(pixel);
                    int G = Color.green(pixel);
                    int B = Color.blue(pixel);
                    String rHex = Integer.toHexString(R);
                    String gHex = Integer.toHexString(G);
                    String bHex = Integer.toHexString(B);
                    String hexKodu = "#" + rHex + gHex + bHex;
                    //String hex = "#" + Integer.toHexString(pixel);
                    renkBilgiTextView2.setText("HEX KODU: " + hexKodu);
                    rgbBilgiTextView2.setText("R-G-B Değerleri: " + R + "-" + G + "-" + B);
                    for (int i = 0; i< firebaseConnection.getHexList().size(); i++){
                        if (hexKodu.equals(firebaseConnection.getHexList().get(i))){
                            renkAdiTextView2.setText("Renk Adı: "+firebaseConnection.getNameList().get(i));
                        }
                    }
                }
                return true;
            }
        });
    }
}














