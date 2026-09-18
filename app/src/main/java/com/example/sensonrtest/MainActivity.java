package com.example.sensonrtest;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView acc;
    TextView gyro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        acc = findViewById(R.id.acc);
        gyro = findViewById(R.id.gyro);

        acceleromer sensor = new acceleromer(this, acc);
        Gyro gyroscope = new Gyro(this, gyro);



    }

}


