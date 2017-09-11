package com.harshit.flipmoocloginpage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button loginbutton ;
    private EditText emailid,pswd;
    private TextView atmpnos;
    private int nosattemps=5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginbutton=(Button)findViewById(R.id.loginbutton);
        atmpnos=(TextView)findViewById(R.id.atmpnos);
        emailid=(EditText)findViewById(R.id.emailid);
        pswd=(EditText)findViewById(R.id.pswd);
        atmpnos.setText(Integer.toString(nosattemps));
        loginbutton.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        if(emailid.getText().toString().equals("harshitsinghal33@gmail.com")
                && pswd.getText().toString().equals("harshit"))
        {
            Toast.makeText(this,"Correct name and password",Toast.LENGTH_LONG).show();
            Intent i=new Intent(this,Main2Activity.class);
            i.putExtra("username",emailid.getText().toString());
            startActivity(i);
        }
        else
        {
            Toast.makeText(this,"InCorrect username or password",Toast.LENGTH_LONG).show();
            nosattemps--;
            atmpnos.setText(Integer.toString(nosattemps));
            if(nosattemps==0)
            {
                loginbutton.setEnabled(false);
            }
        }
    }
}
