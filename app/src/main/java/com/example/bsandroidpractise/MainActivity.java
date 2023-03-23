package com.example.bsandroidpractise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    private TextView timerTV;
    private SeekBar timerSeekBar;
    private Button startButton;


    private CountDownTimer   countDownTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        timerSeekBar.setMax(30);
        timerSeekBar.setProgress(5);


        timerTV.setText(timerSeekBar.getProgress()+"");
        timerSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                updateUI(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startButton.setEnabled(false);
                 countDownTimer = new CountDownTimer(timerSeekBar.getProgress() * 1000,1000) {
                    @Override
                    public void onTick(long l) {

                        updateUI((int)l/1000);

                    }

                    @Override
                    public void onFinish() {

                        startButton.setEnabled(true);
                        Toast.makeText(MainActivity.this, "Time finished", Toast.LENGTH_SHORT).show();
                    }
                };
                countDownTimer.start();

            }
        });



    }

    private  void updateUI(int secondLeft){

        int minutes = secondLeft/60;

        int seconds = secondLeft - (minutes*60);

        String secondString = String.valueOf(seconds);

        if (secondString.equals("0"))secondString = "00";
        String formattedTime = minutes+"."+seconds +" minutes";
        timerTV.setText(formattedTime);




    }

    private void initView() {
        timerTV = findViewById(R.id.timerTV);
        timerSeekBar = findViewById(R.id.timerSeekBar);
        startButton = findViewById(R.id.startButton);
    }


    @Override
    protected void onDestroy() {
        if (countDownTimer!=null)countDownTimer.cancel();
        super.onDestroy();
    }
}