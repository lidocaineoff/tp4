package com.example.timelime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home_4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home4);

    }


    //переход в новое окно
    public void newShablon(View v){
        Intent intent = new Intent(this, NewShablon_5.class);
        Global.startWork = 0;
        Global.relax = 0;
        startActivity(intent);
    }

    //переход в таймер помидора
    public void Pomodoro(View v){
        Intent intent = new Intent(this, Timer_6.class);
        Global.startWork = 6000;
        Global.relax = 10000;
        startActivity(intent);
    }

    public void newTimer(View v){
        Intent intent = new Intent(this, Timer_6.class);
        Global.startWork = Global.newTimeS;
        Global.relax = Global.newTimeR;
        startActivity(intent);
    }
}