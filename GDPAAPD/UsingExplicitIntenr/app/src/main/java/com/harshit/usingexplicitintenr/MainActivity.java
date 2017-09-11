package com.harshit.usingexplicitintenr;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button b1;
    EditText txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.button1);
        txt=(EditText)findViewById(R.id.myfeel);
        b1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        Intent i;
        PackageManager managerob=getPackageManager();
        i=managerob.getLaunchIntentForPackage("com.harshit.flipmooctemperaturecalculator");
        if(i==null)
        {
            return;
        }
        i.addCategory(Intent.CATEGORY_LAUNCHER);
        startActivity(i);

//        Intent t1=new Intent(this,SecondPage.class);
//        t1.putExtra("feeling",txt.getText().toString());
//        startActivity(t1);

    }
}
