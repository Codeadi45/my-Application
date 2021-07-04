package com.example.myapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.ArrayList;

public class uploadsactivity extends AppCompatActivity {

    EditText  edittext,Faculty;
    Spinner  spinner;
    ImageView uploadpdf;
    TextView Choose;
    ImageView Select;
    StorageReference storageReference;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uploadsactivity);
        Select = (ImageView) findViewById(R.id.select);
        spinner = (Spinner) findViewById(R.id.sp1);
        Choose = (TextView)  findViewById(R.id.textView2);
        Faculty = (EditText) findViewById(R.id.faculty);
        edittext = (EditText) findViewById(R.id.editText3) ;
        edittext.setBackgroundResource(R.drawable.backtext);
        firebaseAuth = FirebaseAuth.getInstance();

        uploadpdf = (ImageView) findViewById(R.id.upload);
        storageReference = FirebaseStorage.getInstance().getReference();
        databaseReference = FirebaseDatabase.getInstance().getReference("uploads");
        ArrayList<String> courses = new ArrayList<String>();
        courses.add("Select");
        courses.add("OPERATING SYSTEM");
        courses.add("DBMS");
        courses.add("WEBTECHNOLOGIES");
        courses.add("SOFTWARE TESTING");
        courses.add("DCCN");
        courses.add("DSA");
        courses.add("TOC");
        courses.add("DLM");
        courses.add("EEE");
        courses.add("AOD");
        courses.add("ALA");
        courses.add("CALCULUS");
        courses.add("NIS");
        ArrayAdapter<String> arrayadapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,courses);
        arrayadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayadapter);
        uploadpdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(uploadsactivity.this, "uploaded Successfully", Toast.LENGTH_LONG).show();
                startActivity(new Intent(uploadsactivity.this,assignmentactivity.class));
            }
        });
        Select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectPDF();
            }
        });
    }

    private void selectPDF() {
        Intent intent = new Intent();
        intent.setType("*/*");
        intent.setAction(intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"FILE SELECT"),1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1 && resultCode== RESULT_OK && data!=null && data.getData()!=null){


            uploadPDFFILEFIREBASE(data.getData());
        }
    }
    private void uploadPDFFILEFIREBASE(Uri data){
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Uploading...");
        progressDialog.show();
        final StorageReference reference = storageReference.child("uploads/" + System.currentTimeMillis()+".pdf");
        reference.putFile(data)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        putPDF pdf = new putPDF(edittext.getText().toString().toLowerCase(), uri.toString(), spinner.getSelectedItem().toString(),Faculty.getText().toString());

                        databaseReference.child(databaseReference.push().getKey()).setValue(pdf);
                        progressDialog.dismiss();
                        Choose.setText(System.currentTimeMillis()+".pdf");
                        Toast.makeText(uploadsactivity.this, "File selected", Toast.LENGTH_LONG).show();

                    }
                });




            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                double progress = (100.0*snapshot.getBytesTransferred()/snapshot.getTotalByteCount());
                progressDialog.setMessage("Uploaded" + (int) progress+"%");
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
        startActivity(new Intent(uploadsactivity.this,MainActivity.class));
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.logoutmenu:{
                Logout();
                return true;

            }
            case R.id.backmenu:{
                startActivity(new Intent(uploadsactivity.this,assignmentactivity.class));
                return true;

            }

        }
        return super.onOptionsItemSelected(item);
    }


}
