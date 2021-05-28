package com.example.myapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;

public class balaactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balaactivity);
        PDFView pdfbal = (PDFView) findViewById(R.id.pdf3);

        pdfbal.fromAsset("FALLSEM2020-21_MAT3004_TH_VL2020210101187_Reference_Material_I_13-Jul-2020_Module-1_System_of_Linear_Equations (2)-merged (2).pdf").load();

    }
}
