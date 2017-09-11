package com.harshit.activitieslifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this,"OnCreate wad called",Toast.LENGTH_SHORT).show();
        Log.i("MyActivityTAG","OnCreate wad called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"OnStart wad called",Toast.LENGTH_SHORT).show();
        Log.i("MyActivityTAG","OnStart wad called");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"OnResume wad called",Toast.LENGTH_SHORT).show();
        Log.i("MyActivityTAG","OnResume wad called");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this,"OnRestart wad called",Toast.LENGTH_SHORT).show();
        Log.i("MyActivityTAG","OnRestart wad called");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this,"OnPause wad called",Toast.LENGTH_SHORT).show();
        Log.i("MyActivityTAG","OnPause wad called");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this,"OnStop wad called",Toast.LENGTH_SHORT).show();
        Log.i("MyActivityTAG","OnStop wad called");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"OnDestroy wad called",Toast.LENGTH_SHORT).show();
        Log.i("MyActivityTAG","OnDestroy wad called");

    }
}
