package com.example.timelime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Home_4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home4);
    }


    //переход в новое окно
    public void startNewActivity(View v){
        Intent intent = new Intent(this, NewShablon_5.class);
        startActivity(intent);
    }
}