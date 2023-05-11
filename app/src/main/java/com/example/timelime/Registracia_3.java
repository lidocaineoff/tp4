package com.example.timelime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registracia_3 extends AppCompatActivity {
    private EditText email_registr;
    private EditText password_registr;
    private Button btn_registr;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registracia3);
        mAuth=FirebaseAuth.getInstance();
        email_registr=findViewById(R.id.email_registr);
        password_registr =findViewById(R.id.password_registr);
        btn_registr=findViewById(R.id.btn_registr);


        btn_registr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (email_registr.getText().toString().isEmpty() || password_registr.getText().toString().isEmpty()){
                    Toast.makeText(Registracia_3.this, "Заполните все пустые поля", Toast.LENGTH_SHORT).show();
                }else {
                    mAuth.createUserWithEmailAndPassword(email_registr.getText().toString().trim(),password_registr.getText().toString().trim()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Intent intent= new Intent(Registracia_3.this, MainActivity.class);
                                startActivity(intent);
                            }else {
                                Toast.makeText(Registracia_3.this, "Ошибка", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
}