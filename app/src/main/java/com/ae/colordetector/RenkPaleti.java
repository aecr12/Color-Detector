package com.ae.colordetector;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.slider.Slider;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;

public class RenkPaleti extends AppCompatActivity {
    int degerR;
    int degerG;
    int degerB;
    String hexR;
    String hexG;
    String hexB;
    String hex;
    Button buttonKaydet;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.renk_paleti);
        ImageView imageViewPalet = findViewById(R.id.imageViewPalet);
        SeekBar seekBarR = findViewById(R.id.seekBarR);
        SeekBar seekBarG = findViewById(R.id.seekBarG);
        SeekBar seekBarB = findViewById(R.id.seekBarB);
        TextView textViewHexBilgi = findViewById(R.id.textViewHexBilgi);
        buttonKaydet = findViewById(R.id.buttonKaydet);
        degerR = seekBarR.getProgress();
        hexR = Integer.toHexString(degerR);

        degerG = seekBarG.getProgress();
        hexG = Integer.toHexString(degerG);

        degerB = seekBarB.getProgress();
        hexB = Integer.toHexString(degerB);

        hex = "#"+hexR+hexG+hexB;
        textViewHexBilgi.setText(hex);
        imageViewPalet.setBackgroundColor(Color.rgb(degerR,degerG,degerB));

        seekBarR.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                degerR = i;
                hexR = Integer.toHexString(degerR);
                if (hexR == "0"){
                    textViewHexBilgi.setText("#"+"00"+hexG+hexB);
                }else{
                    textViewHexBilgi.setText("#"+hexR+hexG+hexB);
                }
                imageViewPalet.setBackgroundColor(Color.rgb(degerR,degerG,degerB));
                hex = "#"+hexR+hexG+hexB;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarG.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                degerG = i;
                hexG = Integer.toHexString(degerG);
                if(hexG == "0"){
                    textViewHexBilgi.setText("#"+hexR+"00"+hexB);
                }else{
                    textViewHexBilgi.setText("#"+hexR+hexG+hexB);
                }
                imageViewPalet.setBackgroundColor(Color.rgb(degerR,degerG,degerB));
                hex = "#"+hexR+hexG+hexB;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBarB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                degerB = i;
                hexB = Integer.toHexString(degerB);
                if (hexB =="0"){
                    textViewHexBilgi.setText("#"+hexR+hexG+"00");
                }else{
                    textViewHexBilgi.setText("#"+hexR+hexG+hexB);
                }
                imageViewPalet.setBackgroundColor(Color.rgb(degerR,degerG,degerB));
                hex = "#"+hexR+hexG+hexB;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        buttonKaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPref = RenkPaleti.this.getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("hex",hex);
                editor.commit();
                System.out.println("Başarıyla yazıldı");
            }
        });

    }
}
