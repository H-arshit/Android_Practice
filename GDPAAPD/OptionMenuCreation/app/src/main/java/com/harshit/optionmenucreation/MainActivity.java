package com.harshit.optionmenucreation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.myoptionmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.searchme:
                Toast.makeText(this,"search clicked",Toast.LENGTH_SHORT).show();
                break;
            case R.id.settinginmenus:
                Toast.makeText(this,"setting clicked",Toast.LENGTH_SHORT).show();
                break;
            case R.id.accountinfo:
                Toast.makeText(this,"account info clicked",Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
