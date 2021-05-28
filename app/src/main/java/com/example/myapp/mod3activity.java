package com.example.myapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;

public class mod3activity extends AppCompatActivity {
    PDFView PDF3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mod3activity);

        PDF3 = (PDFView) findViewById(R.id.pdf3);

        PDF3.fromAsset("FALLSEM2018-19_MAT1011_ETH_SJT323_VL2018191001406_Reference Material I_MODULE-3_MAT1011_Multi variable  Calculus.pdf").load();

    }
}
