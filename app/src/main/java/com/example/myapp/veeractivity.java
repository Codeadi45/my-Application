package com.example.myapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;

public class veeractivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veeractivity);

        PDFView pdfver = (PDFView) findViewById(R.id.pdf2);

        pdfver.fromAsset("ALA Veeru Combined.pdf").load();

    }


}
