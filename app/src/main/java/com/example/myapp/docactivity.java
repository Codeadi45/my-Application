package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;

public class docactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docactivity);
        Intent note = getIntent();
        PDFView PDF = (PDFView) findViewById(R.id.pdf1);

        PDF.fromAsset("FALLSEM2019-20_MAT2002_ETH_VL2019201000545_Reference_Material_I_09-Sep-2019_Laplace_transform_Formula.pdf").load();

    }
}
