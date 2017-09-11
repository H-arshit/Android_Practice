package com.harshit.contextfloatingview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nameinput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameinput=(EditText)findViewById(R.id.nameinput);
        registerForContextMenu(nameinput);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        switch (v.getId())
        {
            case R.id.nameinput:
                getMenuInflater().inflate(R.menu.contextmenu,menu);
                break;
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.copyid:
                Toast.makeText(this,"Copied",Toast.LENGTH_SHORT).show();
                break;
            case R.id.pasteid:
                Toast.makeText(this,"paste",Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
