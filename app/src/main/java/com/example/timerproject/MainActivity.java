package com.example.timerproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public boolean started = false;
    public TextView counterText;
    public CountDownTimer counter;
    public long seconds = 60;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.counterText = (TextView) findViewById(R.id.counterTextView);

        Button startButton = (Button) findViewById(R.id.startButton);
        startButton.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (started == false) {
                    started = true;
                    TimeConverter tc = new TimeConverter(seconds);
                    counter = new CountDownTimer(tc.getSeconds() * 1000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            tc.setSeconds(millisUntilFinished / 1000);
                            seconds = millisUntilFinished / 1000;
                            counterText.setText(tc.toString());
                        }

                        public void onFinish() {
                            counterText.setText("00:00");
                        }
                    }.start();
                }
            }
        });

        Button pauseButton = (Button) findViewById(R.id.pauseButton);
        pauseButton.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                counter.cancel();
                started = false;
            }
        });

        Button resetButton = (Button) findViewById(R.id.resetButton);
        resetButton.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                counterText.setText("01:00");
                seconds = 60;
                counter.cancel();
                started = false;
            }
        });
    }
}