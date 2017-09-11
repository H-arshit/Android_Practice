package com.harshit.alarmmanager;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

public class Standup extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationManagerCompat notimngr=NotificationManagerCompat.from(context);
        NotificationCompat.Builder noti=new NotificationCompat.Builder(context);
         noti.setContentTitle("StandUp Comedy");
        noti.setContentText("Harshit");
        noti.setSmallIcon(android.R.drawable.alert_dark_frame);

        Intent i=new Intent(context,StandUpActivity.class);
        PendingIntent pd=PendingIntent.getActivity(context,1,i,0);
        noti.setContentIntent(pd);
        noti.setAutoCancel(true);
        notimngr.notify(1,noti.build());
    }
}
