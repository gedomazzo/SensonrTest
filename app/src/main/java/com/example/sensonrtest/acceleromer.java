package com.example.sensonrtest;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.widget.TextView;
import java.util.ArrayList;

public class acceleromer implements ISensor, SensorEventListener {
    private float x, y, z;

    private ArrayList<Float[]> data = new ArrayList<Float[]>();
    private final Sensor accelerometer;
    private final SensorManager sensorManager;
    private final TextView acc;




    public acceleromer(Context context, TextView acc){
        this.acc = acc;
        this.x = 0;
        this.y = 0;
        this.z = 0;

        this.sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        this.accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        if (accelerometer != null) {
            sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        this.x = Math.round(event.values[0] * 100) / 100;
        this.y = Math.round(event.values[1] * 100) / 100;
        this.z = Math.round(event.values[2] * 100) / 100;



        acc.setText(String.valueOf(x + " " + y + " " + z));

        Float[] temp = {x, y, z};
        data.add(temp);


    }

    public float getX(){
        return this.x;
    }

    public float getY(){
        return this.y;
    }

    public float getZ(){
        return this.z;
    }

    public ArrayList<Float[]> getData(){return this.data;}

    }

