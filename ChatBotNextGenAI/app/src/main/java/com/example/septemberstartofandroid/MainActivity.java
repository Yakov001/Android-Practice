package com.example.septemberstartofandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        System.out.println("What is this?");

        final EditText text = (EditText) findViewById(R.id.editTextTextPersonName);
        final Button button = (Button) findViewById(R.id.button);
        final TextView viewText = (TextView) findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String question = text.getText().toString();

                if (question.equals("Здарова")){
                    viewText.setText("Ну ЗДАРОВА");
                }
                if (question.equals("Как дела?")){
                    viewText.setText("Норм, как сам?");
                }
                if (question.equals("Норм")){
                    viewText.setText("Ничего нового )");
                }
            }
        });
    }

    //public static void main(String[] args) {
    //    System.out.println("What am I?");
    //}
}