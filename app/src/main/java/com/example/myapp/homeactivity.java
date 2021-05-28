package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class homeactivity extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    ImageView imag1, imag2;
    TextView eng, books;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeactivity);
        firebaseAuth = FirebaseAuth.getInstance();
        imag1 = (ImageView) findViewById(R.id.engineering);
        imag2 = (ImageView) findViewById(R.id.books);
        eng = (TextView) findViewById(R.id.textView4);
        books = (TextView) findViewById(R.id.textView5);

        imag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(homeactivity.this, engineerActivity.class));
            }
        });
        imag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(homeactivity.this,assignmentactivity.class));
            }
        });


    }
}