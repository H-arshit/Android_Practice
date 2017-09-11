package com.harshit.services;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button startbutton,stopbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startbutton=(Button)findViewById(R.id.startbutton);
        stopbutton=(Button)findViewById(R.id.stopbutton);
        startbutton.setOnClickListener(this);
        stopbutton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.startbutton)
        {
            Intent i1=new Intent(this,MyownSrevice.class);
            startService(i1);

        }
        else if(R.id.stopbutton==v.getId())
        {
            Intent i2=new Intent(this,MyownSrevice.class);
            stopService(i2);
        }

    }
}
