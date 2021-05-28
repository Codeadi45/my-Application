package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class gosignActivity extends AppCompatActivity {
    private static  String TAG = "gosignActivity";
    private static  String KEY_EMAIL = "USER EMAIL";
    private static  String KEY_PASSWORD = "PASSWORD";
    private static  String KEY_USER = "NAME";

    public EditText username,userpassword,useremail;
    public ImageView goback,done;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private FirebaseUser user;
    private FirebaseAuth firebaseAuth;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gosign);

        username=(EditText)findViewById(R.id.eTname);
        userpassword=(EditText)findViewById(R.id.eTpassword);
        useremail=(EditText)findViewById(R.id.eTemail);
        goback =(ImageView) findViewById(R.id.back);
        done=(ImageView) findViewById(R.id.sighn);
        firebaseAuth = FirebaseAuth.getInstance();

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String user_name = username.getText().toString().trim();
                final String user_email=useremail.getText().toString().trim();
                final String user_pass=userpassword.getText().toString().trim();

                if(Validate()){
                    firebaseAuth.createUserWithEmailAndPassword(user_email,user_pass)
                            .addOnCompleteListener(gosignActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {


                                        sendemailverification();



                                    }
                                }


                            }).addOnFailureListener(gosignActivity.this, new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(gosignActivity.this,"Use verified email ",Toast.LENGTH_SHORT).show();
                                }
                            });


                    Map < String, String > DATA = new HashMap<String, String>();
                    DATA.put(KEY_USER,user_name);
                    DATA.put(KEY_EMAIL,user_email);
                    byte[] inputData = userpassword.getText().toString().getBytes();
                    byte[] outputData = new byte[0];
                    String shaN = "SHA-1";
                    try {
                        outputData = sha.encryptSHA(inputData, shaN);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    BigInteger shaData;
                    int signum = 1;
                    shaData = new BigInteger(signum, outputData);

                    int i = 16;
                    final String user_password = shaData.toString(i);
                    DATA.put(KEY_PASSWORD,user_password);
                    db.collection("users")
                            .add(DATA)
                            .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                @Override
                                public void onSuccess(DocumentReference documentReference) {
                                    Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.w(TAG, "Error adding document", e);
                                }
                            });












                }
            }
        });
        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(gosignActivity.this,MainActivity.class));
            }
        });


    }

    private Boolean Validate(){
        Boolean result = false;
        String name = username.getText().toString();
        String password = userpassword.getText().toString();
        String email = useremail.getText().toString();
        if(name.isEmpty() || email.isEmpty() || password.isEmpty() ){
            Toast.makeText(this,"please enter all the details",Toast.LENGTH_SHORT).show();
        }else{
            result = true;
        }
        return result;
    }
    private  void sendemailverification() {
        user = firebaseAuth.getCurrentUser();
        if (user != null) {
            user.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(gosignActivity.this, "Successfully Registered,Verification email sent", Toast.LENGTH_SHORT).show();
                        firebaseAuth.signOut();
                        finish();

                    } else {
                        Toast.makeText(gosignActivity.this, "Verification mail hasn't been sent!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
