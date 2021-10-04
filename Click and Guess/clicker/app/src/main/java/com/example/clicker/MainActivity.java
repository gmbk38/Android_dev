package com.example.clicker;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView mainText;
    ImageButton mainBtn;
    Button minusBtn, resetBtn;
    private long score = 0;

    private void counter(long x){
        String s;
        if (x <= 0) {
            x = 0;
            score = 0;
            s = "Кликов: " + x + " раз";
        }
        else if ((x % 10 > 1) && (x % 10 < 5)){
            s = "Кликов: " + x + " раза";
        }
        else {
            s = "Кликов: " + x + " раз";
        }
        mainText.setText(s.toCharArray(), 0, s.length());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainText = (TextView) findViewById(R.id.textView);
        mainBtn = (ImageButton) findViewById(R.id.btn1);
        minusBtn = (Button) findViewById(R.id.btn2);
        resetBtn = (Button) findViewById(R.id.btn3);

        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score++;
                counter(score);
            }
        };
        mainBtn.setOnClickListener(clickListener);

        View.OnClickListener clickListener1 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score--;
                counter(score);
            }
        };
        minusBtn.setOnClickListener(clickListener1);

        View.OnClickListener clickListener2 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score = 0;
                counter(score);
            }
        };
        resetBtn.setOnClickListener(clickListener2);
    }
}

