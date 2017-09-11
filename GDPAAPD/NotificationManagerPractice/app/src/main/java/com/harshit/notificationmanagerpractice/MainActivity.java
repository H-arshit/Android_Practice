package com.harshit.notificationmanagerpractice;

import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button notificationbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notificationbutton=(Button)findViewById(R.id.notificationbutton);
        notificationbutton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        NotificationManagerCompat notmngr=NotificationManagerCompat.from(this);
        NotificationCompat.Builder mynot=new NotificationCompat.Builder(this);
        mynot.setContentTitle("New Notification");
        mynot.setContentTitle("this is shit");
        mynot.setSmallIcon(android.R.drawable.stat_notify_voicemail);
        Intent i=new Intent(this,MainActivity.class);
        PendingIntent pd=PendingIntent.getActivity(this,1,i,0);
        mynot.setContentIntent(pd);
        mynot.setAutoCancel(true);
        notmngr.notify(1,mynot.build());


    }
}
