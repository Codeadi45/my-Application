package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class branchActivity extends AppCompatActivity {
    private ImageView CSE,ECE,CIVIL,MECH,ELEC,BIOTECH;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branch);
        CSE = (ImageView) findViewById(R.id.cse);
        ECE = (ImageView) findViewById(R.id.ece);
        CIVIL = (ImageView) findViewById(R.id.civil);
        MECH = (ImageView) findViewById(R.id.mech);
        ELEC = (ImageView) findViewById(R.id.elect);
        BIOTECH = (ImageView) findViewById(R.id.biotech);
        CSE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(branchActivity.this, assignmentactivity.class));
            }
        });
        CIVIL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(branchActivity.this, civilactivity.class));
            }
        });


    }
}