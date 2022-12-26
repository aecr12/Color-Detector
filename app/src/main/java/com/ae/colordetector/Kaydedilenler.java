package com.ae.colordetector;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Kaydedilenler extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.kaydedilenler);
        super.onCreate(savedInstanceState);
        TextView baslik = findViewById(R.id.baslik);
        TextView kaydedilenler = findViewById(R.id.kaydedilenler);
        SharedPreferences sharedPreferences = getSharedPreferences("name", Context.MODE_PRIVATE);
        String val = sharedPreferences.getString("name","hex");
        kaydedilenler.setText(val);
    }
}
