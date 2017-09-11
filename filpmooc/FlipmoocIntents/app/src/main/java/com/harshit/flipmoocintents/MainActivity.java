package com.harshit.flipmoocintents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button nextactbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nextactbutton=(Button)findViewById(R.id.nextactbutton);
        nextactbutton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i=new Intent(this,Main2Activity.class);
        i.putExtra("Buttondata",nextactbutton.getText().toString());
        startActivity(i);
    }
}
