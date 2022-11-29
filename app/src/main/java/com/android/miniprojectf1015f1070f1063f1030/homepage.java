package com.android.miniprojectf1015f1070f1063f1030;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class homepage extends AppCompatActivity {
    //variable name created
    Button notifyBtn;
    MediaPlayer music;
    Button btn1,btn2,btn3,btn4,btn5,btn6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);


        btn1 = findViewById(R.id.btnOurself);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity1(); //activity intent method run
            }
            private void openActivity1() {
                Intent intent1 = new Intent(homepage.this, ourself.class);
                startActivity(intent1);
            }

        });

        btn6 = findViewById(R.id.btnNoti);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity1(); //activity intent method run
            }
            private void openActivity1() {
                Intent intent6 = new Intent(homepage.this, notification.class);
                startActivity(intent6);
            }

        });

        btn2 = findViewById(R.id.btnFriends);
        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openActivity1(); //activity intent method run
            }
            private void openActivity1() {
                Intent intent2 = new Intent(homepage.this, friends.class);
                startActivity(intent2);
            }
        });
        btn3 = findViewById(R.id.btnFamily);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity1(); //activity intent method run
            }
            private void openActivity1() {
                Intent intent3 = new Intent(homepage.this, family.class);
                startActivity(intent3);
            }
        });
        btn5 = findViewById(R.id.btnMessage);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity1(); //activity intent method run
            }
            private void openActivity1() {
                Intent intent3 = new Intent(homepage.this, message.class);
                startActivity(intent3);
            }
        });
        //btn link to video activity
        btn4 = findViewById(R.id.btnVideo);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity1(); //activity intent method run
            }
            private void openActivity1() {
                Intent intent5 = new Intent(homepage.this, video.class);
                startActivity(intent5);
            }
        });
    }
    //player method function play
    public void play(View v) {
        if (music == null) {
            music = MediaPlayer.create(this, R.raw.videoo);
            Toast.makeText(this, "MediaPlayer is Play", Toast.LENGTH_SHORT).show();
            music.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                //music finish player stop
                public void onCompletion(MediaPlayer mp) {stopPlayer();}
            });
        }
        music.start();
    }
    //player method function pause
    public void pause(View v) {
        if (music != null) {
            music.pause();
            Toast.makeText(this, "MediaPlayer is Pause", Toast.LENGTH_SHORT).show();
        }
    }
    //player method function stop
    public void stop(View v) {
        stopPlayer();
    }
    private void stopPlayer() {
        if (music != null) {
            music.release();
            music = null;
            Toast.makeText(this, "MediaPlayer is Stopped", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onStop() {
        super.onStop();
        stopPlayer();
    }
}