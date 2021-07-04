package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class mathactivity extends AppCompatActivity {
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mathactivity);
        firebaseAuth = FirebaseAuth.getInstance();
    }
    public void calc (View view) {
        Intent calculus = new Intent(this, descactivity.class);
        startActivity(calculus);
    }
    public void ALA (View view) {
        Intent ala = new Intent(this, alaactivity.class);
        startActivity(ala);
    }
    public void STATS (View view) {
        Intent stats = new Intent(this, descactivity.class);
        startActivity(stats);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
    private void Logout(){
        firebaseAuth.signOut();
        finish();
        startActivity(new Intent(mathactivity.this,MainActivity.class));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.logoutmenu:{
                Logout();
                return true;

            }
            case R.id.backmenu:{
                startActivity(new Intent(mathactivity.this,engineerActivity.class));
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
