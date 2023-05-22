package com.example.sensorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private SensorManager sensorManager;
    private View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list_sensor(view);
    }
    public void list_sensor(View view){
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> deviceSensors = sensorManager.getSensorList(Sensor.TYPE_ALL);
        TextView list= findViewById(R.id.list_sensor);
        TextView number= findViewById(R.id.Text1);
        number.setText("Number of sensors: "+deviceSensors.size());

        for (Sensor s: deviceSensors){
            list.append(s.getName()+"\n");
        }
    }
    public void new_activity(View view){
        Intent intent = new Intent(this, second.class);
        startActivity(intent);
    }
    public void new_activity2(View view){
        Intent intent = new Intent(this, third.class);
        startActivity(intent);
    }
}