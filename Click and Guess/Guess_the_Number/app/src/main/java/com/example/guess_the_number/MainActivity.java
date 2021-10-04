package com.example.guess_the_number;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView tvInfo;
    EditText etInput;
    Button bControl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvInfo = (TextView)findViewById(R.id.textView1);
        etInput = (EditText)findViewById(R.id.editTextNumber);
        bControl = (Button)findViewById(R.id.btn1);
        int score = 1 + (int) ( Math.random() * 100 );

        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = etInput.getText().toString();
                if (val.trim().isEmpty()){
                    tvInfo.setText(getResources().getString(R.string.error));
                }
                int attempt = Integer.parseInt(etInput.getText().toString());
                if (attempt == score){
                    tvInfo.setText(getResources().getString(R.string.hit));
                }
                else if (attempt < score){
                    tvInfo.setText(getResources().getString(R.string.behind));
                }
                else if (attempt > score){
                    tvInfo.setText(getResources().getString(R.string.ahead));
                }
            }
        };
        bControl.setOnClickListener(clickListener);

    }


}