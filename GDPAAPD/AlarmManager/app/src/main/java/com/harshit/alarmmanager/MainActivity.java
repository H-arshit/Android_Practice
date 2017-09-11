package com.harshit.alarmmanager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button startbutton,stopbutton;
    AlarmManager myalarm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startbutton=(Button)findViewById(R.id.startbutton);
        stopbutton=(Button)findViewById(R.id.stopbutton);
        myalarm=(AlarmManager)getSystemService(ALARM_SERVICE);
        startbutton.setOnClickListener(this);
        stopbutton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.startbutton:
                Intent i=new Intent();
                i.setAction("com.standup");
                i.addCategory("android.intent.category.DEFAULT");
                PendingIntent pd=PendingIntent.getBroadcast(this,10,i,0);
                myalarm.setRepeating(AlarmManager.RTC_WAKEUP,System.currentTimeMillis(),1000*30,pd);

                break;
            case R.id.stopbutton:
                Intent i1=new Intent();
                i1.setAction("com.standup");
                i1.addCategory("android.intent.category.DEFAULT");
                PendingIntent pd1=PendingIntent.getBroadcast(this,10,i1,0);
                myalarm.cancel(pd1);

                break;
        }
    }
}
