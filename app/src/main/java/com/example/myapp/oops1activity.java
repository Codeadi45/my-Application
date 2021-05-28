package com.example.myapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import com.github.barteksc.pdfviewer.PDFView;

public class oops1activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oops1activity);
        PDFView PDF = (PDFView) findViewById(R.id.oop1);

        PDF.fromAsset("oops1.pdf").load();

    }
}
