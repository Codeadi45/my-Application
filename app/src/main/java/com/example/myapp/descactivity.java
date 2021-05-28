package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class descactivity extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descactivity);
        Intent calculus = getIntent();
        firebaseAuth = FirebaseAuth.getInstance();
        bt=(Button) findViewById(R.id.bt3);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(descactivity.this,mod3activity.class));
            }
        });

    }
    public void notes (View view) {
        Intent note = new Intent(this, docactivity.class);
        startActivity(note);
    }
    public void ORD (View view) {
        Intent orderig = new Intent(this, orderactivity.class);
        startActivity(orderig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
    private void Logout(){
        firebaseAuth.signOut();
        finish();
        startActivity(new Intent(descactivity.this,MainActivity.class));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.logoutmenu:{
                Logout();

            }
        }
        return super.onOptionsItemSelected(item);
    }

}
