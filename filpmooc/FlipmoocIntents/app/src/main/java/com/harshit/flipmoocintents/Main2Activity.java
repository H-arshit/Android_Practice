package com.harshit.flipmoocintents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView textbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle bundleme=getIntent().getExtras();
        textbutton=(TextView)findViewById(R.id.textbutton);
        String str=bundleme.getString("Buttondata");
        textbutton.setText(str);

    }
}
