package com.asterisklab.testyourknowledge;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Creates and links buttons to the layout
        Button nationalBtn = findViewById(R.id.nationalChoice);
        Button internationalBtn = findViewById(R.id.internationalChoice);
        Button  techBtn = findViewById(R.id.techChoice);
        Button geographyBtn = findViewById(R.id.geographyChoice);
        Button historyBtn = findViewById(R.id.historyChoice);


        // Pass variable with different values to QuestionActivity according to which button was pressed
        nationalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String choice = "National";

                Intent nextActivity = new Intent(MainActivity.this, questionActivity.class);
                nextActivity.putExtra("chosenSet", choice);
                startActivity(nextActivity);

            }
        });

        internationalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String choice = "International";

                Intent nextActivity = new Intent(MainActivity.this, questionActivity.class);
                nextActivity.putExtra("chosenSet",choice);
                startActivity(nextActivity);
            }
        });

        techBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String choice = "Tech";

                Intent nextActivity = new Intent(MainActivity.this,  questionActivity.class);
                nextActivity.putExtra("chosenSet",choice);
                startActivity(nextActivity);
            }
        });

        geographyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String choice = "Geography";

                Intent nextActivity = new Intent(MainActivity.this, questionActivity.class);
                nextActivity.putExtra("chosenSet",choice);
                startActivity(nextActivity);
            }
        });

        historyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String choice = "History";

                Intent nextActivity = new Intent(MainActivity.this, questionActivity.class);
                nextActivity.putExtra("chosenSet",choice);
                startActivity(nextActivity);
            }
        });


        }

        // The Main part is in QuestionActivity - Check that out !

}
