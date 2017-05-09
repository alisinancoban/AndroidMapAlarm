package com.example.alisi.mapalarm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private SeekBar distanceControl = null;
    private TextView distance = null;
    private CheckBox vibrate = null;
    private CheckBox rign = null;
    private Toast toast = null;
    private EditText etalarmName = null;
    private EditText etAlarmMessage = null;
    private Button btnMap = null;
    private SeekBar vibraterange = null;
    private TextView tvVibrateTime = null;


    public String alarmName = "";
    public String alarmMessage = "";
    public int progressChanged = 0;
    public boolean vibration = false;
    public boolean ring = false;
    public int vibrateTime = 500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        distanceControl = (SeekBar) findViewById(R.id.seekBar2);
        distance = (TextView) findViewById(R.id.tvDistance);
        vibrate = (CheckBox) findViewById(R.id.vibration);
        rign = (CheckBox) findViewById(R.id.ring);
        etAlarmMessage = (EditText) findViewById(R.id.editText4);
        etalarmName = (EditText) findViewById(R.id.editText3);
        btnMap = (Button) findViewById(R.id.button8);
        vibraterange = (SeekBar) findViewById(R.id.seekBar);
        tvVibrateTime = (TextView) findViewById(R.id.tvVibrate);

        vibraterange.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                vibrateTime = progress * 1000;
                tvVibrateTime.setText(progress + "sn");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        distanceControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
               progressChanged = progress;
                distance.setText(progressChanged + " mt");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        vibrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((CheckBox)v).isChecked())
                {
                    vibration = true;
                    if(toast != null)
                    {
                        toast.cancel();
                    }
                    toast = Toast.makeText(MainActivity.this,"Vibriatio on", Toast.LENGTH_SHORT);
                    toast.show();
                }

                else
                {
                    vibration = false;
                    if(toast != null)
                    {
                        toast.cancel();
                    }
                    toast = Toast.makeText(MainActivity.this,"Vibriatio off", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        rign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((CheckBox)v).isChecked())
                {
                    if(toast != null)
                    {
                        toast.cancel();
                    }
                    toast = Toast.makeText(MainActivity.this,"Rign on", Toast.LENGTH_SHORT);
                    toast.show();
                }

                else
                {
                    if(toast != null)
                    {
                        toast.cancel();
                    }
                    toast = Toast.makeText(MainActivity.this,"Rign off", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                intent.putExtra("DISTANCE", progressChanged);
                intent.putExtra("VIBRATETIME", vibrateTime);
                intent.putExtra("VIBRATION" , vibration);
                startActivity(intent);
            }
        });
    }
}
