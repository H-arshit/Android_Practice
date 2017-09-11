package com.harshit.implicitintents;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button b1,b2,b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.button1);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        Uri uri;
        switch(v.getId())
        {
            case R.id.button1:
                    uri=Uri.parse("http://www.google.com");
                    Intent i=new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(i);
                    break;

            case R.id.button2:
                uri=Uri.parse("geo:20.5937,78.9629");
                Intent i2=new Intent(Intent.ACTION_VIEW,uri );
                startActivity(i2);
                break;
            case R.id.button3:
                uri=Uri.parse("tel:879");
                Intent i3=new Intent(Intent.ACTION_VIEW, uri);
                startActivity(i3);
                break;

        }
    }
}
