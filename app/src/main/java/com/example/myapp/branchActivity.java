package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class branchActivity extends AppCompatActivity {
    private ImageView CSE,ECE,CIVIL,MECH,ELEC,BIOTECH;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branch);
        firebaseAuth = FirebaseAuth.getInstance();
        CSE = (ImageView) findViewById(R.id.cse);
        ECE = (ImageView) findViewById(R.id.ece);
        CIVIL = (ImageView) findViewById(R.id.civil);
        MECH = (ImageView) findViewById(R.id.mech);
        ELEC = (ImageView) findViewById(R.id.elect);
        BIOTECH = (ImageView) findViewById(R.id.biotech);
        firebaseAuth = FirebaseAuth.getInstance();
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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
    private void Logout(){


        firebaseAuth.signOut();
        finish();
        startActivity(new Intent(branchActivity.this,MainActivity.class));
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.logoutmenu:{
                Logout();
                return true;

            }
            case R.id.backmenu:{
                startActivity(new Intent(branchActivity.this,homeactivity.class));
                return true;

            }

        }
        return super.onOptionsItemSelected(item);
    }
}