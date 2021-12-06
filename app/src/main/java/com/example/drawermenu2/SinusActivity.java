package com.example.drawermenu2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SinusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new DrawSinus(this));
    }
}