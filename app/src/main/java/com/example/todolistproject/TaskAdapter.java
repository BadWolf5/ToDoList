package com.example.todolistproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class TaskAdapter extends ArrayAdapter<Task> {
    private Context mContext;
    private int mResource;

    public TaskAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Task> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        convertView = layoutInflater.inflate(mResource, parent, false);

        TextView txtName = convertView.findViewById(R.id.mainText);
        TextView txtDate = convertView.findViewById(R.id.dateLabel);
        TextView txtCategory = convertView.findViewById(R.id.listLabel);

        txtName.setText(getItem(position).getName());
        txtDate.setText((CharSequence) getItem(position).getDueDate());
        txtCategory.setText(getItem(position).getList());
        return convertView;
    }
}
