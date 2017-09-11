package com.harshit.flipmoocsqllite;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText name,monexp,monsal;
    Button addbuttton,viewbutoon;
    static MySqlLiteDataBase mydatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=(EditText)findViewById(R.id.name);
        monexp=(EditText)findViewById(R.id.monexp);
        monsal=(EditText)findViewById(R.id.monsal);
        addbuttton=(Button)findViewById(R.id.addbutton);
        viewbutoon=(Button)findViewById(R.id.viewbutton);
        mydatabase=new MySqlLiteDataBase(this);
        addbuttton.setOnClickListener(this);
        viewbutoon.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.addbutton:
                boolean isins=mydatabase.addintotable(name.getText().toString(),monexp.getText().toString(),monsal.getText().toString());
                if(isins)
                {
                    Toast.makeText(this,"Data Inserted",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(this,"Data Not Inserted",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.viewbutton:
                Cursor res=mydatabase.getAllData();
                if(res.getCount()==0)
                {
                    Toast.makeText(this,"No Data Present",Toast.LENGTH_SHORT).show();

                }
                else
                {
                    Intent i=new Intent(this,Listview.class);
                    startActivity(i);
                }
                break;
        }
    }
}
