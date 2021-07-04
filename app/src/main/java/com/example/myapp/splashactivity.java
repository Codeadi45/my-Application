package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class splashactivity extends AppCompatActivity {
    private static int SLEEP_TIMER = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splashactivity);
        getSupportActionBar().hide();
        LogoLauncher logoLauncher = new LogoLauncher();
        logoLauncher.start();

    }
    private class LogoLauncher extends Thread{
        public void run(){
            try{
                sleep(1000*SLEEP_TIMER);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            if(FirebaseAuth.getInstance().getCurrentUser()==null) {
                startActivity(new Intent(splashactivity.this, MainActivity.class));
                finish();
            }
            else{
                startActivity(new Intent(splashactivity.this, homeactivity.class));
                finish();
            }
        }

    }
}
