package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class engineerActivity extends AppCompatActivity {
        TextView text1,text2,text3,text4,text5,text6;
        ImageView imag1,imag2;
        ImageButton imag3,imag4,imag5,imag6;
        FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_engineer);
        text1 = (TextView)  findViewById(R.id.math);
        text2 = (TextView)  findViewById(R.id.Faculty);
        text3 = (TextView)  findViewById(R.id.dsa);
        text4 = (TextView)  findViewById(R.id.help);
        text5 = (TextView)  findViewById(R.id.lect);
        text6 = (TextView)  findViewById(R.id.chat);
        imag1 = (ImageView) findViewById(R.id.maths);
        imag2 = (ImageView) findViewById(R.id.COURSE);
        imag3 = (ImageButton) findViewById(R.id.DSA);
        imag4 = (ImageButton) findViewById(R.id.HELP);
        imag5 = (ImageButton) findViewById(R.id.LECTURES);
        imag6 = (ImageButton) findViewById(R.id.CHATBOX);
        firebaseAuth = FirebaseAuth.getInstance();

        imag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(engineerActivity.this,mathactivity.class));
            }
        });
        imag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(engineerActivity.this,langactivity.class));
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
        startActivity(new Intent(engineerActivity.this,MainActivity.class));
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.logoutmenu:{
                Logout();
                return true;

            }
            case R.id.backmenu:{
                startActivity(new Intent(engineerActivity.this,homeactivity.class));
                return true;
            }

        }
        return super.onOptionsItemSelected(item);
    }
}
