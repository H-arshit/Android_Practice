package com.harshit.broadcastrecieverpractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button mybroadbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mybroadbutton=(Button)findViewById(R.id.mybroadbutton);
        mybroadbutton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent i=new Intent();
        i.setAction("com.harshit.getnot.love");
        i.addCategory("android.intent.category.DEFAULT");
        sendBroadcast(i);
    }
}
