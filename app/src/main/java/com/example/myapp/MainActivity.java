package com.example.myapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private EditText Name,Password;
    private ImageView LOGIN;
    private FirebaseAuth firebaseauth;
    private ProgressDialog progressdialog;
    private TextView forgotpassword,SIGNUP;
    private Switch shalgo;
    private CheckBox check;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name = (EditText)findViewById(R.id.eTName);
        Password = (EditText)findViewById(R.id.eTPassword);
        LOGIN = (ImageView) findViewById(R.id.login);
        forgotpassword = (TextView)findViewById(R.id.txt);
        SIGNUP = (TextView) findViewById(R.id.signupbt);

        check = (CheckBox) findViewById(R.id.checkbox);




        firebaseauth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseauth.getCurrentUser();
        if(user!=null){
            startActivity(new Intent(MainActivity.this,homeactivity.class));
        }

        progressdialog=new ProgressDialog(this);

        LOGIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Validate(Name.getText().toString(),Password.getText().toString());
            }
        });
        SIGNUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,gosignActivity.class));
            }
        });
        forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,passwordactivity.class));
            }
        });

        check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                else{
                    Password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

    }





    private void Validate(String username,String password){
        progressdialog.setMessage("Wait till we checking firebase");
        progressdialog.show();
        firebaseauth.signInWithEmailAndPassword(username, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    progressdialog.dismiss();
                    checkEmailverification();
                }else{
                    Toast.makeText(MainActivity.this, "please enter the details carefully", Toast.LENGTH_SHORT).show();
                    progressdialog.dismiss();
                }
            }
        });
    }
    private void checkEmailverification(){
        FirebaseUser user = firebaseauth.getInstance().getCurrentUser();
        Boolean emailflag = user.isEmailVerified();
        if(emailflag){
            finish();
            Toast.makeText(MainActivity.this, "Welcome to GET DA", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this,homeactivity.class));
        }else{
            Toast.makeText(this,"Verify your email", Toast.LENGTH_SHORT).show();
            firebaseauth.signOut();
        }
    }

}
