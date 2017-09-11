package com.harshit.asynctasks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
     Button mybutton;
    AsyncTaskClass asy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mybutton=(Button)findViewById(R.id.mybutton);
        mybutton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
    asy=new AsyncTaskClass(this);
        asy.execute();
    }
}
