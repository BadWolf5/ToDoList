package com.example.todolistproject;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class MyListAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private ArrayList<String> name = new ArrayList<>();
    private ArrayList<String> list = new ArrayList<>();
    private ArrayList<String> date = new ArrayList<>();
    private ArrayList<String> completed = new ArrayList<>();

    public MyListAdapter(Activity context, ArrayList name, ArrayList list, ArrayList date, ArrayList completed) {
        super(context, R.layout.list_row, name);
        this.context = context;
        this.name= name;
        this.list = list;
        this.date = date;
        this.completed = completed;
    }
    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View listRow = inflater.inflate(R.layout.list_row, null, true);

        TextView mainTitle = listRow.findViewById(R.id.mainText);
        TextView listTitle = listRow.findViewById(R.id.listLabel);
        TextView dateTitle = listRow.findViewById(R.id.dateLabel);
        CheckBox checkBox = listRow.findViewById(R.id.chkBox);

        // Populate the List
        mainTitle.setText(name.get(position));
        listTitle.setText(list.get(position));
        dateTitle.setText(date.get(position));
        checkBox.setText(completed.get(position));
        return listRow;

    }


}
