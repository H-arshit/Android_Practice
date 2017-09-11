package com.harshit.usingexplicitintenr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondPage extends AppCompatActivity {
    TextView txtvw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);
        txtvw=(TextView)findViewById(R.id.text3);
        Bundle bun=getIntent().getExtras();
        String str=bun.getString("feeling");
        txtvw.setText(str);
    }
}
