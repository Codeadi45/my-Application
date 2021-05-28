package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;


public class alaactivity extends AppCompatActivity {
    RadioButton rd;
    RadioButton ry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alaactivity);

        rd = (RadioButton) findViewById(R.id.veera);
        ry = (RadioButton) findViewById(R.id.bala);
        rd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(alaactivity.this,veeractivity.class));
            }
        });
        ry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(alaactivity.this,balaactivity.class));
            }
        });

    }



}
