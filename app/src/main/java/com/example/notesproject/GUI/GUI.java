package com.example.notesproject.GUI;

import androidx.appcompat.app.AppCompatActivity;

public abstract class GUI{

    protected AppCompatActivity app;

    public GUI(AppCompatActivity app){
        this.app = app;
    }

    public abstract void init();
}
