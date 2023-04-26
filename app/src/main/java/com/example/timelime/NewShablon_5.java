package com.example.timelime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;


public class NewShablon_5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_shablon5);

        NumberPicker numberPickerStart = findViewById(R.id.timePickerWork);
        numberPickerStart.setMinValue(0);
        numberPickerStart.setMaxValue(59);

        NumberPicker numberPickerRelax = findViewById(R.id.timePickerRelax);
        numberPickerRelax.setMinValue(0);
        numberPickerRelax.setMaxValue(59);




        //сохраняет значения тр тр для старта
        numberPickerStart.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                long start = numberPickerStart.getValue();
                Global.newTimeS = start*1000*60;
            }
        });


        //сохраняет значения тр тр для релакска
        numberPickerRelax.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                long relax = numberPickerRelax.getValue();
                Global.newTimeR = relax*1000*60;
            }
        });


    }

    public void Sozdat(View v){
        Intent intent = new Intent(this, Home_4.class);
        startActivity(intent);
    }

}