package com.example.todolistproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    ListView listView;
    public MyDatabase db;
    private MyListAdapter listAdapter;
    private ArrayList<String> name = new ArrayList<>();
    private ArrayList<String> list = new ArrayList<>();
    private ArrayList<String> date = new ArrayList<>();
    private ArrayList<String> completed = new ArrayList<>();
    private ArrayList<Integer> idArray = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Initializers
        db = new MyDatabase(this);
        listView = findViewById(R.id.theList);
        listAdapter = new MyListAdapter(this, name, list, date, completed);

        //Create Fake Data. // To be Fixed After
        //String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());

        // Custom Adapter
        //TaskAdapter taskAdapter = new TaskAdapter(this,R.layout.list_row,arrayList);
        listView.setAdapter(listAdapter);

        // Add Task Button
        Button addTask = findViewById(R.id.addButton);
        addTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, TaskInput.class);
                MainActivity.this.startActivity(myIntent);
            }
        });

        displayData();
    }
    @Override
    protected void onResume() {
        super.onResume();
        listAdapter.notifyDataSetChanged();
        displayData();
    }

    public void displayData() {
        // Avoids repeating data
        name.clear();
        list.clear();
        date.clear();
        completed.clear();

        ListView listView = findViewById(R.id.theList);

        Cursor cursor = db.getData();
        while (cursor.moveToNext()) {
            idArray.add(cursor.getInt(0));
            name.add(cursor.getString(1));
            list.add(cursor.getString(2));
            date.add(cursor.getString(3));
            completed.add(cursor.getString(4));

            listView.setAdapter(listAdapter);
            listAdapter.notifyDataSetChanged();

        }

        cursor.close();
    }
}