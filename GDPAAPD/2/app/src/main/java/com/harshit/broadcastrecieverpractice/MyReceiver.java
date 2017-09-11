package com.harshit.broadcastrecieverpractice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"This is my first broadcast reciever",Toast.LENGTH_SHORT).show();
    }
}
