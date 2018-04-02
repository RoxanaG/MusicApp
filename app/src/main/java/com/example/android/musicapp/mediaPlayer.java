package com.example.android.musicapp;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class mediaPlayer extends Activity  {
    int songRes;
    String songName;
    public TextView SongName;
    private MediaPlayer mediaPlayer;
    private double timeElapsed = 0, finalTime = 0;
    private int forwardTime = 2000, backwardTime = 2000;
    private SeekBar positionBar;
    private Object updatepositionBar;

    private Handler durationHandler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mediaplayer);


        if (getIntent().getExtras() != null) {
            songRes = getIntent().getExtras().getInt("Song");
            songName = getIntent().getExtras().getString("SongName");
        }
        initializeViews();

    }

    public void initializeViews() {
        SongName = (TextView) findViewById(R.id.textName);
        mediaPlayer = MediaPlayer.create(this, songRes);
        finalTime = mediaPlayer.getDuration();
        positionBar = findViewById(R.id.positionBar);
        SongName.setText(songName);
        positionBar.setMax((int) finalTime);
        positionBar.setClickable(false);


    }

    public void play(View view) {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            timeElapsed = mediaPlayer.getCurrentPosition();
            positionBar.setProgress((int) timeElapsed);
            durationHandler.postDelayed((Runnable) updatepositionBar, 100);
        } else {
            mediaPlayer.start();
        }
        Runnable updatepositionBar = new Runnable() {
            @Override
            public void run() {
                timeElapsed = mediaPlayer.getCurrentPosition();
                positionBar.setProgress((int) timeElapsed);
                double timeRemaining = finalTime - timeElapsed;
                durationHandler.postDelayed(this, 100);
            }
        };


    }

   public void forward(){
        if (mediaPlayer !=null){
            int currentPosition = mediaPlayer.getCurrentPosition();
            if (currentPosition +forwardTime <= mediaPlayer.getDuration()){
                mediaPlayer.seekTo(currentPosition + forwardTime);
            }else {
                mediaPlayer.seekTo(mediaPlayer.getDuration());
            }
        }
   }
   public void backward(){
        if (mediaPlayer!=null){
            int currentPosition = mediaPlayer.getCurrentPosition();
            if (currentPosition - backwardTime >= 0){
                mediaPlayer.seekTo(currentPosition - backwardTime);
            }else {
                mediaPlayer.seekTo(0);
            }
        }
   }
}

