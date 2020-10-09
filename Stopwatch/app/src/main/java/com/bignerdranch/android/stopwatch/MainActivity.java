package com.bignerdranch.android.stopwatch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {
    private Chronometer chronometer;
    private boolean running;
    private long pauseOffset;

    // Save instance state variables
    private final String KEY = "key";
    private final String KEY2 = "key2";
    private int timePassed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chronometer= findViewById(R.id.chronometer);
        if (timePassed != 0){
            startChronometer(chronometer.getRootView());
        }
    }

    public void startChronometer(View view) {
        if (!running){
            chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffset - timePassed);
            chronometer.start();
            running = true;
            timePassed = 0;
        }
    }

    public void stopChronometer(View view) {
        if (running){
            chronometer.stop();
            pauseOffset = SystemClock.elapsedRealtime() - chronometer.getBase();
            running = false;
        }
    }

    public void resetChronometer(View view) {
        chronometer.setBase(SystemClock.elapsedRealtime());
        pauseOffset = 0;
        stopChronometer(view);
    }

    // Methods for recovery when we turn the phone and restart the activity.

    @Override
    public void onSaveInstanceState(Bundle SavedInstanceState) {
        super.onSaveInstanceState(SavedInstanceState);
        timePassed = (int) (SystemClock.elapsedRealtime() - chronometer.getBase());
        SavedInstanceState.putInt(KEY, timePassed);
        SavedInstanceState.putBoolean(KEY2, running);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        running = savedInstanceState.getBoolean(KEY2, false);
        timePassed = savedInstanceState.getInt(KEY, 5000);

        // The next method NEVER WORKS. Need to be fixed.
        startChronometer(chronometer.getRootView());
    }
}