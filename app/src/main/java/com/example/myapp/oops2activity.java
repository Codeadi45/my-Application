package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.github.barteksc.pdfviewer.PDFView;

public class oops2activity extends AppCompatActivity {
    PDFView PDF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oops2activity);
        PDF = (PDFView) findViewById(R.id.oop2);

        PDF.fromAsset("oops 2.pdf").load();

    }
}
