package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class moduleactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moduleactivity);
        Intent cplus = getIntent();
    }
    public void mod1 (View view) {
        Intent dekho = new Intent(this, lectactivity.class);
        startActivity(dekho);
    }
}
