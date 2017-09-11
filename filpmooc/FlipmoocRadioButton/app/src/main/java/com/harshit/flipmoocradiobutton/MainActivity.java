package com.harshit.flipmoocradiobutton;

//import android.provider.MediaStore;
//import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    RadioGroup rdgrp;
    RadioButton radio;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rdgrp=(RadioGroup)findViewById(R.id.radiogrp);
        b1=(Button)findViewById(R.id.button1);
        b1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    {

        // v.getId() returns integer
        if(R.id.radio1==rdgrp.getCheckedRadioButtonId())
        {
            radio=(RadioButton)findViewById(R.id.radio1);

            Toast.makeText(this,radio.getText().toString(),Toast.LENGTH_SHORT).show();

        }
        else   if(R.id.radio2==rdgrp.getCheckedRadioButtonId())
        {
            radio=(RadioButton)findViewById(R.id.radio2);

            Toast.makeText(this,radio.getText().toString(),Toast.LENGTH_SHORT).show();

        }
        else   if(R.id.radio3==rdgrp.getCheckedRadioButtonId())
        {
            radio=(RadioButton)findViewById(R.id.radio3);

            Toast.makeText(this,radio.getText().toString(),Toast.LENGTH_SHORT).show();

        }
        else if(R.id.radio4==rdgrp.getCheckedRadioButtonId())
        {
            radio=(RadioButton)findViewById(R.id.radio4);

            Toast.makeText(this,radio.getText().toString(),Toast.LENGTH_SHORT).show();

        }
        else
        {
            Toast.makeText(this,"You did not select anything",Toast.LENGTH_SHORT).show();
        }


    }

}
