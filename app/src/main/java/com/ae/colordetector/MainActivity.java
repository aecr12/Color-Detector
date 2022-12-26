package com.ae.colordetector;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Toolbar myToolbar;
    public Toolbar getMyToolbar(){
        return myToolbar;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonInternettenSec = findViewById(R.id.butonInternettenSec);
        Button buttonCanliTanima = findViewById(R.id.butonCanliTanima);
        Button buttonDosyalardanSec = findViewById(R.id.butonDosyalardanSec);
        Button butonFotografCek = findViewById(R.id.butonFotografCek);
        Button buttonRenkPaleti = findViewById(R.id.butonRenkPaleti);

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
                Intent intent = new Intent(MainActivity.this,CanliTanima.class);
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

        buttonInternettenSec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, InternettenSecim.class);
                startActivity(intent);
            }
        });

        myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        myToolbar.setTitle("Color Detector");
        myToolbar.inflateMenu(R.menu.options_menu);

        myToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intent=new Intent(MainActivity.this, Kaydedilenler.class);
                startActivity(intent);
                return false;
            }
        });

    }

}