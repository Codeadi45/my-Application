package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;


public class alaactivity extends AppCompatActivity {
    RadioButton rd;
    RadioButton ry;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alaactivity);

        rd = (RadioButton) findViewById(R.id.veera);
        firebaseAuth = FirebaseAuth.getInstance();
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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
    private void Logout(){


        firebaseAuth.signOut();
        finish();
        startActivity(new Intent(alaactivity.this,MainActivity.class));
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.logoutmenu:{
                Logout();

            }
            case R.id.backmenu:{
                startActivity(new Intent(alaactivity.this,mathactivity.class));

            }

        }
        return super.onOptionsItemSelected(item);
    }



}
