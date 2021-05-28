package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class oops4activity extends AppCompatActivity {
    PDFView PDF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oops4activity);
        PDF = (PDFView) findViewById(R.id.oop4);

        PDF.fromAsset("OOPS 4.pdf").load();
    }
}
