package com.example.timelime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Avtorizacia_2 extends AppCompatActivity {
    private EditText email_login;
    private EditText password_login;
    private Button btn_login;
    private TextView regist_txt;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avtorizacia2);
        email_login = findViewById(R.id.email_login);
        password_login = findViewById(R.id.password_login);
        btn_login=findViewById(R.id.btn_login);
        regist_txt=findViewById(R.id.regist_txt);
        mAuth=FirebaseAuth.getInstance();
        regist_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Avtorizacia_2.this, Registracia_3.class);
                startActivity(intent);
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (email_login.getText().toString().isEmpty() || password_login.getText().toString().isEmpty()) {
                    Toast.makeText(Avtorizacia_2.this, "Заполните все пустые поля", Toast.LENGTH_SHORT).show();
                } else {
                    mAuth.signInWithEmailAndPassword(email_login.getText().toString().trim(),password_login.getText().toString().trim()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override                          public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Intent intent= new Intent(Avtorizacia_2.this, Home_4.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(Avtorizacia_2.this, "Ошибка, не правильно введен логин или пароль", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });


    }
}
