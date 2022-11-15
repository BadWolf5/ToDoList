package com.example.todolistproject;

import java.util.Date;

public class Task {
    String name;
    String list;
    Date dueDate;
    Boolean completed;

    public Task(String name, String list, Date dueDate, Boolean completed) {
        this.name = name;
        this.list = list;
        this.dueDate = dueDate;
        this.completed = completed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getList() {
        return list;
    }

    public void setList(String list) {
        this.list = list;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

}