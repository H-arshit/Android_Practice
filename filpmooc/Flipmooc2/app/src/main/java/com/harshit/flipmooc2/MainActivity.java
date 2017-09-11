package com.harshit.flipmooc2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button bt;
    EditText et1,et2;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt=(Button)findViewById(R.id.button1);
        et1=(EditText)findViewById(R.id.number1);
        et2=(EditText)findViewById(R.id.number2);
        tv=(TextView)findViewById(R.id.text1);
        bt.setOnClickListener(this);
    }


    @Override
    public void onClick(View v)
    {
        String str1=et1.getText().toString();
        String str2=et2.getText().toString();
        int result=Integer.parseInt(str1)+Integer.parseInt(str2);
        //String strrest=String.valueOf(result);
        tv.setText(String.valueOf(result));
    }
}
