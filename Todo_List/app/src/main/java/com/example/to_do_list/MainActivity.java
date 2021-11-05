package com.example.to_do_list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button Btn1;
    Button Btn2;
    Button Btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Btn1 = (Button) findViewById(R.id.non_active);
        Btn1.setOnClickListener(this);

        Btn2 = (Button) findViewById(R.id.during);
        Btn2.setOnClickListener(this);

        Btn3 = (Button) findViewById(R.id.completed);
        Btn3.setOnClickListener(this);
    }

    public void onClick(View v) {
        Intent intent;

        switch(v.getId()) {
            case R.id.non_active:
                intent = new Intent("com.example.intent.action.non_active");
                startActivity(intent);
                break;
            case R.id.during:
                intent = new Intent("com.example.intent.action.during");
                startActivity(intent);
                break;
            case R.id.completed:
                intent = new Intent("com.example.intent.action.completed");
                startActivity(intent);
                break;
        }
    }
}