package com.harshit.flipmoocservices;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText emailid,Subject,body;
    Button sendbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailid=(EditText)findViewById(R.id.emailid);
        Subject=(EditText)findViewById(R.id.Subject);
        body=(EditText)findViewById(R.id.body);
        sendbutton=(Button)findViewById(R.id.sendbutton);
        sendbutton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //RegExpression
        Intent i=new Intent(Intent.ACTION_SEND);
        String email=emailid.getText().toString();
        String sub=Subject.getText().toString();
        String content=body.getText().toString();
        i.setType("*/*"); // for every application present in the phone
        i.putExtra(Intent.EXTRA_EMAIL,email);
        i.putExtra(Intent.EXTRA_SUBJECT,sub);
        i.putExtra(Intent.EXTRA_TEXT,content);
        startActivity(i);
    }
}
