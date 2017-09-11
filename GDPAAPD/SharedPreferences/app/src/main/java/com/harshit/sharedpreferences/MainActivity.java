package com.harshit.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText mytext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mytext=(EditText)findViewById(R.id.mytext);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sh1=getSharedPreferences("myname",MODE_APPEND);
        String s1=sh1.getString("user","");
        mytext.setText(s1);
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sh=getSharedPreferences("myname",MODE_PRIVATE);
        SharedPreferences.Editor myedit=sh.edit();
        myedit.putString("user",mytext.getText().toString());
        myedit.commit();
    }
}
