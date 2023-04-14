package com.example.timelime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import java.util.Locale;

public class Timer_6 extends AppCompatActivity {

   // Button btn_Start;
   // TextView timer_txt;

    //private static final long Start_time = Global.startWork;
    //private static final long Start_time2 = Global.relax;
    private  TextView view_cnt;
    private Button btn_StartStop;
    private Button btn_Reset;
    private CountDownTimer mCountTimer;
    private boolean TimerRun;
    private long mTimerleft = Global.startWork; //Start_time;
    private long pereriv = Global.relax; //Start_time2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer6);
        view_cnt = findViewById(R.id.view_cnt);
        btn_StartStop = findViewById(R.id.btn_Start_Stop);
        btn_Reset = findViewById(R.id.btn_Reset);


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
    }

    private void startTimer(){
        mCountTimer = new CountDownTimer(mTimerleft, 1000) {
            @Override
            public void onTick(long l) {
                mTimerleft= l;
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
        mTimerleft = Global.startWork;  //Start_time;
        updatecount();
        btn_Reset.setVisibility(View.INVISIBLE);
        btn_StartStop.setVisibility(View.VISIBLE);
    };
    private void updatecount(){
        int min = (int)(mTimerleft/1000)/60;
        int sec = (int)(mTimerleft/1000)%60;
        String timerFormet = String.format(Locale.getDefault(),"%02d:%02d",min,sec);
        view_cnt.setText(timerFormet);
    };

    public void zavershit(View v){
        Intent intent = new Intent(this, Home_4.class);
        startActivity(intent);
    }

}

/*
if(TimerRun == false){
                    updatecount2();
                    mCountTimer = new CountDownTimer(pereriv, 1000) {
                        @Override
                        public void onTick(long l) {
                            pereriv= l;
                            updatecount2();
                        }

                        @Override
                        public void onFinish() {

                            TimerRun =  false;
                            btn_StartStop.setText("Запуск");
                            btn_StartStop.setVisibility(View.INVISIBLE);
                            btn_Reset.setVisibility(View.VISIBLE);
                        }
                    }.start();
 */