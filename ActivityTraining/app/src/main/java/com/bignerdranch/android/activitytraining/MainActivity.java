package com.bignerdranch.android.activitytraining;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private boolean addedSugar;
    private boolean addedPepper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.main_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = SecondActivity.createIntent(MainActivity.this,
                        addedSugar,addedPepper);
                //Intent intent1 = new Intent ( MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });



        final Button addSugar = (Button) findViewById(R.id.add_sugar_button);
        addSugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                Intent what = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(what);
                 */
                addedSugar = true;
                Toast.makeText(MainActivity.this, "Sugar added", Toast.LENGTH_SHORT).show();
                addSugar.setEnabled(false);
            }
        });

        final Button addPepper = (Button) findViewById(R.id.add_pepper_button);
        addPepper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addedPepper = true;
                Toast.makeText(MainActivity.this, "Pepper added", Toast.LENGTH_SHORT).show();
                addPepper.setEnabled(false);
            }
        });
    }
}