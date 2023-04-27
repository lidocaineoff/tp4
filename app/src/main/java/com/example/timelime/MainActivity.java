package com.example.timelime;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash1);

        //запуск загрузочного окна
        //так как авторизацию мы пока еще не сделали, то переходим на главное окно
        // потом поменять в 22 строке Home_4.class на Avtorizacia_2.class
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this, Home_4.class);
                startActivity(i);
                finish();
            }
        }, 3*1000);
    }



}