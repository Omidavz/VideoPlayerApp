package com.example.videoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    VideoView videoView ;
    EditText video_et ;
    Button play_btn , new_video_btn ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Play Video From URL
        videoView = findViewById(R.id.video_vv);
        video_et = findViewById(R.id.video_et);
        play_btn = findViewById(R.id.play_btn);
        new_video_btn = findViewById(R.id.new_video_btn);
        new_video_btn.setVisibility(View.GONE);

        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        mediaController.setMediaPlayer(videoView);
        videoView.setMediaController(mediaController);


        play_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String videoUrl = video_et.getText().toString();
                if (video_et.length()>0){
                    Uri uri = Uri.parse(videoUrl);
                    videoView.setVideoURI(uri);
                    videoView.start();
                    video_et.setText("");
                    video_et.setVisibility(View.GONE);
                    new_video_btn.setVisibility(View.VISIBLE);

                }else {
                    Toast.makeText(MainActivity.this, "Please enter valid link", Toast.LENGTH_SHORT).show();
                }


            }
        });

        new_video_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new_video_btn.setVisibility(View.GONE);
                play_btn.setVisibility(View.VISIBLE);
                video_et.setVisibility(View.VISIBLE);
            }
        });
    }
}