package com.example.myapp;

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
import com.google.firebase.auth.FirebaseAuth;

public class passwordactivity extends AppCompatActivity {
    private EditText passwordemail;
    private Button reset;
    private FirebaseAuth firebaseauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passwordactivity);
        passwordemail = (EditText)findViewById(R.id.eTemail);
        reset =(Button)findViewById(R.id.btpass);
        firebaseauth = FirebaseAuth.getInstance();
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String useremail = passwordemail.getText().toString().trim();
                if(useremail.equals("")){
                    Toast.makeText(passwordactivity.this,"Please enter your registered emailid",Toast.LENGTH_SHORT).show();

                }else{
                    firebaseauth.sendPasswordResetEmail(useremail).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(passwordactivity.this,"reset Password email sent",Toast.LENGTH_SHORT).show();
                                finish();
                                startActivity(new Intent(passwordactivity.this,MainActivity.class));
                            }else{
                                Toast.makeText(passwordactivity.this,"error ,may be  u are not registered",Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                }
            }
        });
    }
}
