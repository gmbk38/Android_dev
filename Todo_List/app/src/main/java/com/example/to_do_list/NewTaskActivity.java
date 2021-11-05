package com.example.to_do_list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewTaskActivity extends AppCompatActivity {

    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);

        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.send);
        button.setOnClickListener(this::onClick);
    }

    public void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("name", editText.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}