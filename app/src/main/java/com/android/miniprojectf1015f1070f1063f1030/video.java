package com.android.miniprojectf1015f1070f1063f1030;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class video extends AppCompatActivity {
    //variable create
    Button button;
    VideoView video;
    Uri uri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        //call variable video from xml
        video=(VideoView) findViewById(R.id.videoCoffee);
        MediaController mc=new MediaController(this);
        mc.setMediaPlayer(video);
        video.setMediaController(mc);
        //call video from raw folder
        video.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.videoo));

        //call variable
        button = findViewById(R.id.btnBack1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openActivity4(); //activity intent method run
            }
            private void openActivity4(){
                Intent intent4 = new Intent(video.this, homepage.class);
                startActivity(intent4);

            }
        });
    }
}