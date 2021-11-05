package com.example.intent_filters;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button mainBtn1;
    Button mainBtn2;
    Button mainBtn3;
    EditText etInput;
    TextView tvName1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainBtn1 = (Button) findViewById(R.id.btnTime);
        mainBtn1.setOnClickListener(this);

        mainBtn2 = (Button) findViewById(R.id.btnDate);
        mainBtn2.setOnClickListener(this);

        mainBtn3 = (Button) findViewById(R.id.btnName);
        mainBtn3.setOnClickListener(this);

        etInput = (EditText)findViewById(R.id.etLName);

        tvName1 = (TextView) findViewById(R.id.tvName);

    }

    public void onClick(View v) {
        Intent intent;

        switch(v.getId()) {
            case R.id.btnTime:
                intent = new Intent("com.example.intent.action.showtime");
                intent.putExtra("lname", etInput.getText().toString());
                startActivity(intent);
                break;
            case R.id.btnDate:
                intent = new Intent("com.example.intent.action.showdate");
                intent.putExtra("lname", etInput.getText().toString());
                startActivity(intent);
                break;
            case R.id.btnName:
                intent = new Intent(this, NameActivity.class);
                startActivityForResult(intent, 1);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data == null) {return;}
        String name = data.getStringExtra("name");
        tvName1.setText("Your name is " + name);
    }


}