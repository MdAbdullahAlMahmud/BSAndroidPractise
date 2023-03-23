package com.example.bsandroidpractise;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private AudioManager audioManager;
    private Button playButton, pauseButton;
    private SeekBar seekBar;

    private MediaPlayer mediaPlayer;

    private TextView currentVolumeTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();


        audioManager =(AudioManager) getSystemService(AUDIO_SERVICE);
        mediaPlayer  = MediaPlayer.create(this,R.raw.music);

        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);



        seekBar.setMax(maxVolume);
        seekBar.setProgress(currentVolume);
        currentVolumeTV.setText("Max Volume "+maxVolume+"   Current Volume " + currentVolume);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int newVolume, boolean b) {

                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,newVolume,0);
                Log.v("Volume","" + newVolume);
                currentVolumeTV.setText("Max Volume "+maxVolume+"   Current Volume " + currentVolume);
                seekBar.setProgress(newVolume);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
            }
        });
        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.pause();
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.pause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer!=null){
            mediaPlayer.stop();
            mediaPlayer.release();
        }
    }

    private void initView() {
        playButton = findViewById(R.id.playButton);
        pauseButton = findViewById(R.id.pauseButton);
        seekBar = findViewById(R.id.audioSeekBar);
        currentVolumeTV = findViewById(R.id.currentVolumeTV);


    }
}