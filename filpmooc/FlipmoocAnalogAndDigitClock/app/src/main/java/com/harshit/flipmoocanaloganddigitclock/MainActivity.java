package com.harshit.flipmoocanaloganddigitclock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.Button;
import android.widget.DigitalClock;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button ;
    DigitalClock digiclk;
    AnalogClock analogclock;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        digiclk=(DigitalClock)findViewById(R.id.digiclock);
        analogclock=(AnalogClock)findViewById(R.id.anaclock);
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        if(analogclock.getVisibility()==AnalogClock.GONE)
        {
            analogclock.setVisibility(AnalogClock.VISIBLE);
            digiclk.setVisibility(DigitalClock.GONE);
        }
        else
        {
            analogclock.setVisibility(AnalogClock.GONE);
            digiclk.setVisibility(DigitalClock.VISIBLE);
        }

    }
}
