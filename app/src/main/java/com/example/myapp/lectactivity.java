package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.github.barteksc.pdfviewer.PDFView;

public class lectactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lectactivity);
        Intent dekho = getIntent();
        VideoView VID = findViewById(R.id.videoView);
        VID.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.lecture);
        MediaController media = new MediaController(this);
        VID.setMediaController(media);
        media.setAnchorView(VID);
        VID.start();
    }
}
