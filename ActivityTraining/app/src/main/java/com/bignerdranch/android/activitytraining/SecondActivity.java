package com.bignerdranch.android.activitytraining;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.Nullable;

import org.w3c.dom.Text;

public class SecondActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        Button backButton = (Button) findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toFirstActivity = new Intent(SecondActivity.this,
                        MainActivity.class);
                startActivity(toFirstActivity);
            }
        });

        TextView sugarAddedText = (TextView) findViewById(R.id.sugar_added_text);
        sugarAddedText.setText();

        boolean addedSugar = getIntent().getBooleanExtra("AddedSugar", false);
        boolean addedPepper = getIntent().getBooleanExtra( "AddedPepper", false);
    }



    public static Intent createIntent (Context packageContext, boolean addedSugar, boolean addedPepper) {
        Intent intent = new Intent (packageContext, SecondActivity.class);
        intent.putExtra ("AddedSugar", addedSugar);
        intent.putExtra ("AddedPepper", addedPepper);
        return intent;
    }
}
