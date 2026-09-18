package com.example.sensonrtest;

import android.hardware.SensorListener;

import java.util.ArrayList;

public interface ISensor{

    public ArrayList<Float[]> getData();
}
