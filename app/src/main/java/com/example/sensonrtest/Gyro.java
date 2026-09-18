package com.example.sensonrtest;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.widget.TextView;

import java.util.ArrayList;

public class Gyro implements ISensor, SensorEventListener {
    private float rx, ry, rz;
    private final Sensor Gyroscope;
    private final SensorManager sensorManager;
    private ArrayList<Float[]> data = new ArrayList<Float[]>();

    TextView gyro;

    public Gyro(Context context, TextView gyro){
        this.gyro = gyro;
        this.rx = 0;
        this.ry = 0;
        this.rz = 0;
        this.sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        this.Gyroscope = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        if (Gyroscope != null) {
            sensorManager.registerListener(this, Gyroscope, SensorManager.SENSOR_DELAY_NORMAL);
        }

    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        this.rx = Math.round(event.values[0]*100)/100;
        this.ry = Math.round(event.values[1]*100)/100;
        this.rz = Math.round(event.values[2]*100)/100;

        gyro.setText(String.valueOf(rx + " " + ry + " " + rz));

        Float[] temp = {rx, ry, rz};
        data.add(temp);

    }

    public float getrX(){
        return this.rx;
    }

    public float getrY(){
        return this.ry;
    }

    public float getrZ(){
        return this.rz;
    }

    @Override
    public ArrayList<Float[]> getData(){return this.data;}

}
