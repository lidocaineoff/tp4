package com.example.timelime;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;


public class Home_4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home4);


        //нажимаем на кнопку и всплывает окно
        ImageButton menu = (ImageButton) findViewById(R.id.dialogMenu);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Dialog dialog = new Dialog(Home_4.this);
                dialog.setContentView(R.layout.dialog_menu);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.getWindow().setGravity(Gravity.RIGHT | Gravity.TOP);


            /*
                //в диалоге нажимаем кнопку Выйти и Валя потом сделает выход из аккаунта))))
                TextView vihod = (TextView) dialog.findViewById(R.id.vihod);
                vihod.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        dialog.dismiss();
                    }
                });
            */

                dialog.show();

            }
        });


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
        Global.startWork = 1500000;
        Global.relax = 300000;
        Global.name = "Помодоро";
        startActivity(intent);
    }

    public void Devyatnatrid(View v){
        Intent intent = new Intent(this, Timer_6.class);
        Global.startWork = 5400000;
        Global.relax = 1800000;
        Global.name = "Помодоро";
        startActivity(intent);
    }

    public void newTimer(View v){
        Intent intent = new Intent(this, Timer_6.class);
        Global.startWork = Global.newTimeS;
        Global.relax = Global.newTimeR;
        startActivity(intent);
    }
}