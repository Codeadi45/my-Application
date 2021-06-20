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

public class assignmentactivity extends AppCompatActivity {
    Spinner spinner;
    FloatingActionButton upload;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignmentactivity);
        spinner = (Spinner) findViewById(R.id.csespinner);
        upload = (FloatingActionButton) findViewById(R.id.bt) ;
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(assignmentactivity.this,uploadsactivity.class));
            }
        });
        ArrayList<String> courses = new ArrayList<String>();
        courses.add("Select");
        courses.add("OPERATING SYSTEM");
        courses.add("DBMS");
        courses.add("WEBTECHNOLOGIES");
        courses.add("SOFTWARE TESTING");
        courses.add("DCCN");
        courses.add("DSA");
        courses.add("TOC");
        courses.add("DLM");
        courses.add("EEE");
        courses.add("AOD");
        courses.add("ALA");
        courses.add("CALCULUS");
        courses.add("NIS");
        ArrayAdapter<String> arrayadapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,courses);
        arrayadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayadapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:

                        break;
                    case 1:
                        startActivity(new Intent(assignmentactivity.this,OSACTIVITY.class));

                        break;
                    case 2:
                        startActivity(new Intent(assignmentactivity.this,dbmsactivity.class));

                        break;
                    case 3:
                        startActivity(new Intent(assignmentactivity.this,webtechactivity.class));


                        break;
                    case 4:
                        startActivity(new Intent(assignmentactivity.this,stestingactivity.class));

                        break;
                    case 5:
                        startActivity(new Intent(assignmentactivity.this,dccnactivity.class));
                        break;
                    case 6:
                        startActivity(new Intent(assignmentactivity.this,dsaactivity.class));
                        break;
                    case 7:
                        startActivity(new Intent(assignmentactivity.this,tocactivity.class));
                        break;
                    case 8:
                        startActivity(new Intent(assignmentactivity.this,dlmactivity.class));

                        break;
                    case 9:
                        startActivity(new Intent(assignmentactivity.this,eeeActivity.class));
                        break;
                    case 10:
                        startActivity(new Intent(assignmentactivity.this,aodactivity.class));

                        break;
                    case 11:
                        startActivity(new Intent(assignmentactivity.this,aladaactivity.class));
                        break;
                    case 12:
                        startActivity(new Intent(assignmentactivity.this,calculusactivity.class));
                        break;
                    case 13:

                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
