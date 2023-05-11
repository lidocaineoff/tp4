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
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class Home_4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home4);

        //получаем email из FB
        // Получаем email пользователя
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        String email = currentUser.getEmail();


        //нажимаем на кнопку и всплывает окно
        ImageButton menu = (ImageButton) findViewById(R.id.dialogMenu);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Dialog dialog = new Dialog(Home_4.this);
                dialog.setContentView(R.layout.dialog_menu);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.getWindow().setGravity(Gravity.RIGHT | Gravity.TOP);


                  // ?? тогда ждем доделанную кнопку, я потом ее помещу на страничку с новым шаблоном *настя*

                TextView vihod = (TextView) dialog.findViewById(R.id.vihod);

                TextView emailTV = (TextView) dialog.findViewById(R.id.textView6);
                emailTV.setText(email);
                vihod.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Home_4.this, Avtorizacia_2.class);
                        startActivity(intent);
                       // dialog.dismiss();
                    }
                });


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
        Global.name = "90/30";
        startActivity(intent);
    }

    public void newTimer(View v){
        Intent intent = new Intent(this, Timer_6.class);
        Global.startWork = Global.newTimeS;
        Global.relax = Global.newTimeR;
        Global.name = "Ваш шаблон";
        startActivity(intent);
    }
}