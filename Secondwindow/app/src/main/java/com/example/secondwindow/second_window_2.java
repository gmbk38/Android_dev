package com.example.secondwindow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class second_window_2 extends AppCompatActivity {

    final String TAG = "States";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_window2);

        Log.d(TAG, "MainActivity: onCreate()");
    }

}