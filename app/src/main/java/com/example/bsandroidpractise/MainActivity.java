package com.example.bsandroidpractise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    private EditText amountEdt;
    private MaterialButton converteCurrencyButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        amountEdt = findViewById(R.id.amountEdt);
        converteCurrencyButton = findViewById(R.id.converteCurrencyButton);
        converteCurrencyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userEnterAmount = amountEdt.getText().toString();
                if (userEnterAmount.isEmpty()){
                    amountEdt.setError("required");
                    return;
                }
                double amount = Double.parseDouble(userEnterAmount);
                double amountInEuro = amount * 1.3;
                String euroSymbol = "\u20ac";
                Toast.makeText(MainActivity.this, userEnterAmount+" is = "+euroSymbol + " "+ amountInEuro , Toast.LENGTH_SHORT).show();

            }
        });




    }
}