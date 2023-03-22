package com.example.bsandroidpractise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private EditText numberEdt;
    private MaterialButton guessButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numberEdt = findViewById(R.id.numberEdt);
        guessButton = findViewById(R.id.guessButton);


        final int min = 1;
        final int max = 20;
        final int randomNumber = new Random().nextInt((max - min) + 1) + min;
        Log.v("Number","Generated Random Number  --> "+ String.valueOf(randomNumber));


        guessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userEnterNumber = numberEdt.getText().toString();
                if (userEnterNumber.isEmpty()){
                    numberEdt.setError("required");
                    return;
                }
                int userGuessNumber = Integer.parseInt(userEnterNumber);
                checkWeatherUserGuessIsRightOrNot(userGuessNumber,randomNumber);


            }
        });

    }


    private void checkWeatherUserGuessIsRightOrNot(int userGuessNumber, int randomNumber){
        if (userGuessNumber>randomNumber){
            Toast.makeText(MainActivity.this,"Your guess is higher",Toast.LENGTH_SHORT).show();
            return;
        }else if (userGuessNumber<randomNumber){
            Toast.makeText(MainActivity.this,"Your guess is lower",Toast.LENGTH_SHORT).show();
            return;
        }else{
            Toast.makeText(MainActivity.this,"Congrats you got me",Toast.LENGTH_SHORT).show();

        }
    }
}