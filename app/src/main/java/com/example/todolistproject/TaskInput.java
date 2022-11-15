package com.example.todolistproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TaskInput extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_input);

        String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());

        EditText titleText = findViewById(R.id.titleText);
        Button dateBtn = findViewById(R.id.dateButton);
        Spinner listSpin = findViewById(R.id.listSpinner);
        Button addBtn = findViewById(R.id.Addbtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabase myDB = new MyDatabase(TaskInput.this);
                myDB.addTask(
                        titleText.getText().toString().trim(),
                        "No List",
                        currentDate.toString(),
//                        dateBtn.getText().toString(),
                        false);

                finish();
            }
        });


    }


}