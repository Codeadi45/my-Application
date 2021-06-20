package com.example.myapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.ArrayList;

public class uploadcivilactivity extends AppCompatActivity {
    EditText  edittext,Faculty;
    Spinner spinner;
    ImageView uploadpdf;
    TextView Choose;
    ImageView Select;
    StorageReference storageReference;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uploadcivilactivity);
        Select = (ImageView) findViewById(R.id.select);
        Choose = (TextView)  findViewById(R.id.textView2);
        Faculty = (EditText) findViewById(R.id.faculty);
        edittext = (EditText) findViewById(R.id.editText3) ;
        spinner = (Spinner) findViewById(R.id.sp2);
        uploadpdf = (ImageView) findViewById(R.id.upload);
        storageReference = FirebaseStorage.getInstance().getReference();
        databaseReference = FirebaseDatabase.getInstance().getReference("uploads");
        ArrayList<String> courses = new ArrayList<String>();
        courses.add("Select");
        courses.add("Surveying");
        courses.add("Soil Mechanics and Foundation Engineering");
        courses.add("Environmental Engineering");
        courses.add("Construction Materials and Techniques");
        courses.add(" Economics");
        courses.add("Fundamentals of Energy, Environment and Climate Change");
        courses.add("Natural Disaster Mitigation and Management");
        courses.add("Renewable Sources of Energy");
        courses.add("Air and Noise Pollution");
        courses.add("Environmental Impact Assessment");
        courses.add(" Urban Planning");
        courses.add("Technical Answers for Real World Problems (TARP)");
        courses.add("Building Drawing");
        courses.add("Structural Analysis");
        courses.add("Water Resource Engineering");
        courses.add(" Transportation Engineering");
        courses.add("Earthquake Engineering");
        courses.add("Advanced Concrete Technology");
        courses.add("Strength of Materials");
        courses.add("Unsaturated Soil Mechanics");
        courses.add("Construction Planning and Management");
        courses.add("Advanced Soil Mechanics");
        courses.add("Ground Improvement Techniques");
        courses.add("Soil Dynamics and Machine Foundation");
        courses.add("Advanced Foundation Engineering");
        ArrayAdapter<String> arrayadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, courses);
        arrayadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayadapter);

        uploadpdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(uploadcivilactivity.this, "uploaded Successfully", Toast.LENGTH_LONG).show();
                startActivity(new Intent(uploadcivilactivity.this,civilactivity.class));
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
                                putPDF pdf = new putPDF(edittext.getText().toString(), uri.toString(), spinner.getSelectedItem().toString(),Faculty.getText().toString());

                                databaseReference.child(databaseReference.push().getKey()).setValue(pdf);
                                progressDialog.dismiss();
                                Choose.setText(System.currentTimeMillis()+".pdf");
                                Toast.makeText(uploadcivilactivity.this, "File selected", Toast.LENGTH_LONG).show();

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
