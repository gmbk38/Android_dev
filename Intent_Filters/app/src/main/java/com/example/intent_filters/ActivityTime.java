package com.example.intent_filters;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ActivityTime extends AppCompatActivity {

//    TextView tvView1;
//    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String time = sdf.format(new Date(System.currentTimeMillis()));

        TextView tvTime = (TextView) findViewById(R.id.tvTime);
        tvTime.setText(time);

//        tvView1 = (TextView)findViewById(R.id.tvView);
//
//        String lName = intent.getStringExtra("lname");
//        tvView1.setText("Your name is: " + lName);
    }
}