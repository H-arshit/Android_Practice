package com.harshit.asynctasksloader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button syncbut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        syncbut=(Button)findViewById(R.id.syncbutton);
        syncbut.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}
