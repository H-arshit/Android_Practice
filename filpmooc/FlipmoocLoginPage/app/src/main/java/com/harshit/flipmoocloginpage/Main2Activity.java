package com.harshit.flipmoocloginpage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView usernameshow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        usernameshow=(TextView)findViewById(R.id.usernameshow);
        Bundle bun=getIntent().getExtras();
        usernameshow.setText(bun.getString("username"));

    }
}
