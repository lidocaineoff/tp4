package com.example.timelime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class Timer_6 extends AppCompatActivity {

    private  TextView view_cnt;
    private Button btn_StartStop;
    private CountDownTimer mCountTimer;
    private boolean TimerRun;
    private long time = Global.startWork;
    int noTimer = 0;
    MediaPlayer player;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer6);
        view_cnt = findViewById(R.id.view_cnt);
        btn_StartStop = findViewById(R.id.btn_Start_Stop);
        player = MediaPlayer.create(this, R.raw.timer_toster);

        btn_StartStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TimerRun) {
                    pauseTimer();
                } else {
                    firstTimer();
                }
            }
        });
        updatecount(time);

    }

    public void firstTimer(){
        mCountTimer = new CountDownTimer(time, 1000) {
            @Override
            public void onTick(long l) {
                time= l;
                updatecount(time);
            }
            @Override
            public void onFinish() {
                player.start();
                TimerRun =  false;
                btn_StartStop.setText("Запуск");
                if(noTimer == 1){
                    return;
                }
               // btn_StartStop.setVisibility(View.INVISIBLE);
                if(time != Global.relax){
                    time = Global.relax;
                    firstTimer();
                    noTimer = 1;
                }
            }
        };
        mCountTimer.start();
        TimerRun = true;
        btn_StartStop.setText("Стоп");
    }

    private void updatecount(long tim){
        int min = (int)(tim/1000)/60;
        int sec = (int)(tim/1000)%60;
        String timerFormet = String.format(Locale.getDefault(),"%02d:%02d",min,sec);
        view_cnt.setText(timerFormet);
    };

    private void pauseTimer(){
        mCountTimer.cancel();
        TimerRun = false;
        btn_StartStop.setText("Запуск");
    };

    public void zavershit(View v){
        Intent intent = new Intent(this, Home_4.class);
        startActivity(intent);
        if (TimerRun) {
            pauseTimer();
            TimerRun =  false;
        }
    }

}


/*
        btn_StartStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TimerRun) {
                    pauseTimer();
                } else {
                    startTimer();
                }
            }
        });



        btn_Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTimer();
            }
        });

        updatecount();

 */




/*
    private void startTimer(){
        mCountTimer = new CountDownTimer(rabota, 1000) {
            @Override
            public void onTick(long l) {
                rabota= l;
                updatecount();
            }

            @Override
            public void onFinish() {
                TimerRun =  false;
                btn_StartStop.setText("Запуск");
                btn_StartStop.setVisibility(View.INVISIBLE);
                btn_Reset.setVisibility(View.VISIBLE);

            }
        }.start();
        TimerRun = true;
        btn_StartStop.setText("Стоп");
        btn_Reset.setVisibility(View.INVISIBLE);



    }


    private void pauseTimer(){
        mCountTimer.cancel();
        TimerRun = false;
        btn_StartStop.setText("Запуск");
        btn_Reset.setVisibility(View.VISIBLE);
    };


    private void resetTimer(){
        rabota = Global.startWork;  //Start_time;
        updatecount();
        btn_Reset.setVisibility(View.INVISIBLE);
        btn_StartStop.setVisibility(View.VISIBLE);
    };


    private void updatecount(){
        int min = (int)(rabota/1000)/60;
        int sec = (int)(rabota/1000)%60;
        String timerFormet = String.format(Locale.getDefault(),"%02d:%02d",min,sec);
        view_cnt.setText(timerFormet);
    };


 */