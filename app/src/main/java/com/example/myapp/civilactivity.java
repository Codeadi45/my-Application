/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit. 
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan. 
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna. 
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus. 
 * Vestibulum commodo. Ut rhoncus gravida arcu. 
 */

package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class civilactivity extends AppCompatActivity {
    Spinner spinnerc;
    FloatingActionButton uploadcivil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_civilactivity);
        spinnerc = (Spinner) findViewById(R.id.civispinner);
        uploadcivil = (FloatingActionButton) findViewById(R.id.bt1);
        uploadcivil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(civilactivity.this, uploadcivilactivity.class));
            }
        });
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
        ArrayAdapter<String> arrayadapter = new ArrayAdapter<String>(civilactivity.this, android.R.layout.simple_spinner_item, courses);
        arrayadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerc.setAdapter(arrayadapter);
        spinnerc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                    case 8:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                    case 18:

                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:


                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}




























