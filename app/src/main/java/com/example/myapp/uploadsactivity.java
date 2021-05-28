package com.example.myapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class uploadsactivity extends AppCompatActivity {

    EditText coursename , edittext,Faculty;
    ImageView uploadpdf;
    TextView Choose;
    ImageView Select;
    StorageReference storageReference;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uploadsactivity);
        Select = (ImageView) findViewById(R.id.select);
        Choose = (TextView)  findViewById(R.id.textView2);
        Faculty = (EditText) findViewById(R.id.faculty);
        edittext = (EditText) findViewById(R.id.editText3) ;
        coursename = (EditText) findViewById(R.id.editText2);
        uploadpdf = (ImageView) findViewById(R.id.upload);
        storageReference = FirebaseStorage.getInstance().getReference();
        databaseReference = FirebaseDatabase.getInstance().getReference("uploads");
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
        intent.setType("application/pdf");
        intent.setAction(intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"PDF FILE SELECT"),1);

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
                        putPDF pdf = new putPDF(edittext.getText().toString(), uri.toString(), coursename.getText().toString(),Faculty.getText().toString());

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


}
