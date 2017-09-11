package com.harshit.flipmoocsavingdatatodatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button savebutton;
    EditText name,surname,age,username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        savebutton=(Button)findViewById(R.id.savebutton);
        savebutton.setOnClickListener(this);
        surname=(EditText)findViewById(R.id.surname);
        age=(EditText)findViewById(R.id.age);
        name=(EditText)findViewById(R.id.name);
        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
    }

    @Override
    public void onClick(View v) {
        SaveData checkit=new SaveData(this);
        checkit.execute("SaveData",name.getText().toString(),surname.getText().toString(),age.getText().toString(),username.getText().toString(),password.getText().toString());


    }
}
