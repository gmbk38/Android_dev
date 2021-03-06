package com.example.to_do_list;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.TintableBackgroundView;

import android.content.Intent;
import android.os.Bundle;
import android.os.FileObserver;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class NonActiviteActivity extends AppCompatActivity {

    FloatingActionButton fab;
    ListView lst;
    ArrayAdapter mArrayAdapter;
    ArrayList mNameList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_non_activite);

        lst = (ListView) findViewById(R.id.list);
        mArrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                mNameList);
        lst.setAdapter(mArrayAdapter);
        registerForContextMenu(lst);

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(this::onClick);
    }

    public void onClick(View view) {
        Intent intent;

        intent = new Intent(this, NewTaskActivity.class);
        startActivityForResult(intent, 1);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
//            case R.id.edit:
//                editItem(info.position); // ??????????, ?????????????????????? ???????????????? ?????? ???????????????????????????? ???????????? ????????
//                return true;
            case R.id.delete:
                deleteItem(info.position); //??????????, ?????????????????????? ???????????????? ?????? ???????????????? ???????????? ????????
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    private void deleteItem(int a) {
        mNameList.remove(a);
        mArrayAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(data == null){
            return ;
        }
        String task_info = data.getStringExtra("name");
        mNameList.add(task_info);
    }
}