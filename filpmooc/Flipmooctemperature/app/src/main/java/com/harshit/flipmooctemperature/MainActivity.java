package com.harshit.flipmooctemperature;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText t1;
    Button b1;
    TextView txt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=(EditText)findViewById(R.id.temperature);
        b1=(Button)findViewById(R.id.button1);
        txt1=(TextView)findViewById(R.id.resulttext);
        b1.setOnClickListener(this);

    }


    @Override
    public void onClick(View v)
    {
        String strtemp=t1.getText().toString();
        float temp=Float.parseFloat(strtemp);
        float result =(temp-32)*(5f/9);
        txt1.setText(String.valueOf(result));

    }
}
