package com.harshit.flipmooctemperaturecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    RadioGroup fromrdgrp,tordgrp;
    Button  convertbutton;
    EditText inputtemp;
    TextView outputtemp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fromrdgrp=(RadioGroup)findViewById(R.id.fromrdgrp);
        tordgrp=(RadioGroup)findViewById(R.id.tordgrp);
        convertbutton=(Button)findViewById(R.id.convertbutton);
        inputtemp=(EditText)findViewById(R.id.inputtemp);
        outputtemp=(TextView)findViewById(R.id.outputtemp);
        convertbutton.setOnClickListener(this);
    }
    public void calculatethetemperature() {

            switch (fromrdgrp.getCheckedRadioButtonId()) {
                case R.id.fromcel:
                    switch (tordgrp.getCheckedRadioButtonId()) {
                        case R.id.tocel:
                            if (!inputtemp.getText().toString().isEmpty())
                                outputtemp.setText(inputtemp.getText().toString());
                            else
                                Toast.makeText(this, "Enter temperature", Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.tofarn:
                            if (!inputtemp.getText().toString().isEmpty()) {
                                float i = Float.parseFloat(inputtemp.getText().toString());
                                i = (i * (9f / 5)) + 32;
                                outputtemp.setText(String.valueOf(i));
                            } else
                                Toast.makeText(this, "Enter temperature", Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.tokel:
                            if (!inputtemp.getText().toString().isEmpty())
                            {       float j = Float.parseFloat(inputtemp.getText().toString());
                            j = j + 273.15f;
                            outputtemp.setText(String.valueOf(j));
                    }else
                            Toast.makeText(this, "Enter temperature", Toast.LENGTH_SHORT).show();
                            break;
                        default:
                            Toast.makeText(this, "Select To temperature", Toast.LENGTH_SHORT).show();
                            break;
                    }
                    break;
                case R.id.fromfarn:
                    switch (tordgrp.getCheckedRadioButtonId()) {
                        case R.id.tocel:
                            if (!inputtemp.getText().toString().isEmpty()) {
                            float i = Float.parseFloat(inputtemp.getText().toString());
                            i = (i - 32) * 5f / 9;
                            outputtemp.setText(String.valueOf(i));
                        }
                            else
                                Toast.makeText(this, "Enter temperature", Toast.LENGTH_SHORT).show();

                        break;
                        case R.id.tofarn:
                            if (!inputtemp.getText().toString().isEmpty())
                            outputtemp.setText(inputtemp.getText().toString());
                            else

                            Toast.makeText(this, "Enter temperature", Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.tokel:
                            if (!inputtemp.getText().toString().isEmpty()) {
                                float j = Float.parseFloat(inputtemp.getText().toString());
                                j = (j + 459.67f) * 5f / 9;
                                outputtemp.setText(String.valueOf(j));
                            }
                            else

                                Toast.makeText(this, "Enter temperature", Toast.LENGTH_SHORT).show();

                            break;
                        default:
                            Toast.makeText(this, "Select To temperature", Toast.LENGTH_SHORT).show();
                            break;
                    }
                    break;
                case R.id.fromkel:
                    switch (tordgrp.getCheckedRadioButtonId()) {
                        case R.id.tocel:
                            if (!inputtemp.getText().toString().isEmpty()){
                            float i = Float.parseFloat(inputtemp.getText().toString());
                            i = i - 273.15f;
                            outputtemp.setText(String.valueOf(i));}
                            else

                            Toast.makeText(this, "Enter temperature", Toast.LENGTH_SHORT).show();

                            break;
                        case R.id.tofarn:
                            if (!inputtemp.getText().toString().isEmpty()){
                            float j = Float.parseFloat(inputtemp.getText().toString());
                            j = (j * (9f / 5)) - 459.67f;
                            outputtemp.setText(String.valueOf(j));}
                           else

                            Toast.makeText(this, "Enter temperature", Toast.LENGTH_SHORT).show();

                            break;
                        case R.id.tokel:
                            if (!inputtemp.getText().toString().isEmpty())
                            outputtemp.setText(inputtemp.getText().toString());
                           else

                            Toast.makeText(this, "Enter temperature", Toast.LENGTH_SHORT).show();

                            break;
                        default:
                            Toast.makeText(this, "Select To temperature", Toast.LENGTH_SHORT).show();
                            break;
                    }
                    break;
                default:
                    Toast.makeText(this, "Select From temperature", Toast.LENGTH_SHORT).show();
                    break;
            }
        }


    @Override
    public void onClick(View v)
    {
        calculatethetemperature();
    }
}
