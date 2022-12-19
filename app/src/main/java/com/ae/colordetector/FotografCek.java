package com.ae.colordetector;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.ae.Utils.FirebaseConnection;

public class FotografCek extends AppCompatActivity {

    private static final int MY_CAMERA_PERMISSION_CODE = 100;
    private static final int CAMERA_REQUEST = 1888;

    Button buttonFotograf;
    ImageView imageViewFotografCek;
    TextView renkBilgiTextView5;
    TextView rgbBilgiTextView5;
    TextView renkAdiTextView5;

    @SuppressLint("ClickableViewAccessibility")
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fotograf_cek);
        buttonFotograf = findViewById(R.id.buttonFotograf);
        renkBilgiTextView5 = findViewById(R.id.renkBilgiTextView5);
        rgbBilgiTextView5 = findViewById(R.id.rgbBilgiTextView5);
        renkAdiTextView5 = findViewById(R.id.renkAdiTextView5);
        imageViewFotografCek = findViewById(R.id.imageViewFotografCek);

        FirebaseConnection firebaseConnection = new FirebaseConnection();
        firebaseConnection.getThread().start();

        buttonFotograf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(new String[]{Manifest.permission.CAMERA}, MY_CAMERA_PERMISSION_CODE);
                } else {
                    Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(cameraIntent, CAMERA_REQUEST);
                }
            }
        });
        imageViewFotografCek.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, @SuppressLint("ClickableViewAccessibility") MotionEvent motionEvent) {
                Bitmap bitmap;
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN || motionEvent.getAction() == MotionEvent.ACTION_MOVE) {
                    bitmap = imageViewFotografCek.getDrawingCache();
                    if (bitmap == null){
                        System.out.println("bitmap boş");
                    }else{
                        System.out.println("bitmap dolu");
                    }
                    int pixel = bitmap.getPixel((int) motionEvent.getX(), (int) motionEvent.getY());
                    int R = Color.red(pixel);
                    int G = Color.green(pixel);
                    int B = Color.blue(pixel);
                    String rHex = Integer.toHexString(R);
                    String gHex = Integer.toHexString(G);
                    String bHex = Integer.toHexString(B);
                    String hexKodu ="#"+ rHex + gHex + bHex;
                    //String hex = "#" + Integer.toHexString(pixel);
                    renkBilgiTextView5.setText("HEX KODU: " + hexKodu);
                    rgbBilgiTextView5.setText("R-G-B Değerleri: " + R + "-" + G + "-" + B);
                    for (int i = 0; i< firebaseConnection.getHexList().size(); i++){
                        if (hexKodu.equals(firebaseConnection.getHexList().get(i))){
                            renkAdiTextView5.setText("Renk Adı: "+firebaseConnection.getNameList().get(i));
                        }
                    }
                }
                return true;
            }
        });
        }

        @Override
        public void onRequestPermissionsResult ( int requestCode, @NonNull String[] permissions,
        @NonNull int[] grantResults){
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            if (requestCode == MY_CAMERA_PERMISSION_CODE) {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "camera permission granted", Toast.LENGTH_LONG).show();
                    Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(cameraIntent, CAMERA_REQUEST);
                } else {
                    Toast.makeText(this, "camera permission denied", Toast.LENGTH_LONG).show();
                }
            }
        }

        @Override
        protected void onActivityResult ( int requestCode, int resultCode, Intent data){
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
                Bitmap photo = (Bitmap) data.getExtras().get("data");
                imageViewFotografCek.setImageBitmap(photo);
                imageViewFotografCek.setDrawingCacheEnabled(true);
            }
        }
    }
