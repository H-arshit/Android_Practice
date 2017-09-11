package com.harshit.flipmoocpswdset;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button b1;
    private EditText t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.button1);
        t1=(EditText)findViewById(R.id.passwordtext);
        b1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        Toast.makeText(this,"I know your password hehehe its " + t1.getText(),Toast.LENGTH_LONG).show();
    }
}
