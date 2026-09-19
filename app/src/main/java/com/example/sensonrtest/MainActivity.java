package com.example.sensonrtest;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView acc, time;
    Button start, finish;
    TextView gyro;
    Experement exp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        acc = findViewById(R.id.acc);
        time = findViewById(R.id.time);
        gyro = findViewById(R.id.gyro);
        start = findViewById(R.id.start);
        finish = findViewById(R.id.finish);


        acceleromer sensor = new acceleromer(this, acc);
        Gyro gyroscope = new Gyro(this, gyro);

        exp = new Experement(sensor, "test");


    }


    public void Start(View view) {
        exp.start();
        time.setText("start");
    }

    public void Finish(View view) {
        exp.stop();
        time.setText(String.valueOf(exp.getTime()));
        Log.d("data", exp.getData().toString());

    }
}


