package com.example.sensonrtest;

import android.hardware.SensorEventListener;

import java.util.ArrayList;

public class Experement {

    private ISensor sensor;
    private int timestamp;
    private boolean isRunning;
    private String Type;
    private String comment;
    private ArrayList<Float[]> data;

    public Experement(ISensor sensor, String comment){
        this.sensor = sensor;

        if (sensor instanceof acceleromer) {
            this.Type = "Acceleromer";
        } else if (sensor instanceof Gyro) {
            this.Type = "Gyro";
        } else {
            this.Type = "Unknown";
        }

        this.comment = comment;
    }

    public void start(){
        this.isRunning = true;

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (isRunning) {
                    timestamp += 1;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
            }
        });
        thread.start();
    }


    public void stop(){
        isRunning = false;
        this.data = sensor.getData();
    }



    public int getTime(){ return this.timestamp; }
    public String getType(){ return this.Type; }
    public String getComment(){ return this.comment; }
    public ArrayList<Float[]> getData(){ return this.data; }

}