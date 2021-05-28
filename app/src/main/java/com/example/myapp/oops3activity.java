package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class oops3activity extends AppCompatActivity {
    PDFView PDF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oops3activity);
        PDF = (PDFView) findViewById(R.id.oop3);

        PDF.fromAsset("OOPS 3.pdf").load();
    }
}
