package com.example.general_settings;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        SeekBar.OnSeekBarChangeListener {

    Button btnSave, btnLoad;
    EditText etName;
    Spinner spinner;
    EditText etDay;
    private TextView mTextView;
    ArrayAdapter<String> adapter;

    String[] groups = { "ПИ20-1", "ПИ20-2", "ПИ20-3", "ПИ20-4", "ПИ20-5", "ПИ20-6"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSave = findViewById(R.id.btnSave);
        btnLoad = findViewById(R.id.btnLoad);
        etName = findViewById(R.id.etName);
        etDay = findViewById(R.id.etBirthday);

        spinner = findViewById(R.id.etGroup);
        adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, groups);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        final SeekBar seekBar = (SeekBar)findViewById(R.id.etAge);
        seekBar.setOnSeekBarChangeListener(this);

        mTextView = (TextView)findViewById(R.id.textView);
        mTextView.setText("0");

        btnSave.setOnClickListener(this);
        btnLoad.setOnClickListener(this);

        loadText();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        mTextView.setText(String.valueOf(seekBar.getProgress()));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSave:
                saveText();
                break;
            case R.id.btnLoad:
                loadText();
                break;
            default:
                break;
        }
    }

    private void saveText() {
        String name = "";
        SharedPreferences pref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = pref.edit();

        name = etName.getText().toString();
        ed.putString("name", name);
        ed.commit();
        Log.i("SPREF", name);

//        String group = "";
//        group = spinner.getSelectedItem().toString();
//        ed.putString("group", group);
//        ed.commit();
//        Log.i("SPREF", group);

        String age = "";
        age = mTextView.getText().toString();
        ed.putString("age", age);
        ed.commit();
        Log.i("SPREF", age);

        String birthday = "";
        birthday = etDay.getText().toString();
        ed.putString("birthday", birthday);
        ed.commit();
        Log.i("SPREF", birthday);
    }

    private void loadText() {
        String name = "";
        String age = "";
        String birthday = "";
        SharedPreferences pref_1 = getPreferences(MODE_PRIVATE);
        name = pref_1.getString("name", "");
        etName.setText(name);

//        String group = "";
//        group = pref_1.getString("group", "");
//        int position = adapter.getPosition(group);
//        spinner.setSelection(position);

        age = pref_1.getString("age", "");
        mTextView.setText(age);

        birthday = pref_1.getString("birthday", "");
        etDay.setText(birthday);
    }

    @Override
    protected void onStop() {
        super.onStop();
        saveText();
    }

}