package com.example.bsandroidpractise;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private GridLayout gridLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }


    public  void  phraseClickListener(View view){
        Button button = (Button) view;
        Toast.makeText(this, ""+ button.getTag(), Toast.LENGTH_SHORT).show();
    }


    private void initView() {
        gridLayout = findViewById(R.id.gridLayout);

    }
}