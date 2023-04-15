package com.example.timelime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;

/*
короче. у нас на 5 окне есть два выбора тр тр . Для часа и для минут.
Но мы не предусмотрели выбор лоя перерыва. У нас есть выбор только для время работы.
И по сути мы в окне 6-таймер используем тоже только одно время - минуты(милисекунды)
Поэтому я предлагаю оставить два тр тр для выбора скок минут будет работа и скок минут будет перерыв.
Только я не знаю как сделать по красоте и по удобствву.
Но два тр тр я сделала. Только не очень тогда получиться, если так будет выглядеть...

Ещё предлагаю немного отредачить свой шаблон.......... надо обсудить. ибо я пока не знаю как реализовывать появившиеся шаблоны. Максимум ток один шаблон.

В окне-4 я создала внизу кнопку. Как работает код.
Нажимая на помодоро - всё рабтает по шаблону и ничего не меняется.
Нажимая на кнопку создать шаблон выходит окно-5 =>
Там мы настраиваем время и это время сахряняется в нижней кнопке в окне-4.
Если мы нажмем на неё, то откроется окно-6 таймера с теми секундами, которые мы сами задовали.

!!! предупреждаю!!!
в тр тр.... путь там и стоит от 0 до 59. но это подразумеваются секунды.
потом как таймер настроим - надеюсь получиться сделать как минуты
 */

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
                Global.newTimeS = start*1000;
            }
        });


        //сохраняет значения тр тр для релакска
        numberPickerRelax.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                long relax = numberPickerRelax.getValue();
                Global.newTimeR = relax*10000;
            }
        });


    }

    public void Sozdat(View v){
        Intent intent = new Intent(this, Home_4.class);
        startActivity(intent);
    }

}