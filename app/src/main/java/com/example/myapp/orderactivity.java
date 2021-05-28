package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class orderactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderactivity);
        Intent orderig = getIntent();
        PDFView ordig = (PDFView) findViewById(R.id.pdf2);
        ordig.fromAsset("FALLSEM2018-19_MAT1011_ETH_SJT323_VL2018191001406_Reference Material I_change of order of integration.pdf").load();
    }
}
