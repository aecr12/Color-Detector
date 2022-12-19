package com.ae.colordetector;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonInternettenSec = findViewById(R.id.butonInternettenSec);
        Button buttonCanliTanima = findViewById(R.id.butonCanliTanima);
        Button buttonDosyalardanSec = findViewById(R.id.butonDosyalardanSec);
        Button butonFotografCek = findViewById(R.id.butonFotografCek);
        Button buttonRenkPaleti = findViewById(R.id.butonRenkPaleti);
        ActionBar windowDecorActionBar = this.getActionBar();
        buttonDosyalardanSec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DosyalardanSecim.class);
                startActivity(intent);
            }
        });
        buttonCanliTanima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,KameradanSecim.class);
                startActivity(intent);
            }
        });
        butonFotografCek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,FotografCek.class);
                startActivity(intent);
            }
        });

        buttonRenkPaleti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RenkPaleti.class);
                startActivity(intent);
            }
        });
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Color Detector");
        // setSupportActionBar(findViewById(R.id.toolbar));
        toolbar.inflateMenu(R.menu.options_menu);
    }

}