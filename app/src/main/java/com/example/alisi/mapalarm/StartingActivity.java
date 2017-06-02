package com.example.alisi.mapalarm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartingActivity extends AppCompatActivity {

    private Button selectNewLocation;
    private Button saveNewLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting);

        selectNewLocation = (Button) findViewById(R.id.SelectNewLocation);
        selectNewLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartingActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


        saveNewLocation = (Button) findViewById(R.id.SaveNewLocation);
        saveNewLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartingActivity.this, SaveMapLocationActivity.class);
                startActivity(intent);
            }
        });

    }
}
