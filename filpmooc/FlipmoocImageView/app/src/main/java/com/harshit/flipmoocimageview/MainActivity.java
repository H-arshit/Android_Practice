package com.harshit.flipmoocimageview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button;
    ImageView imageview;
    int index=0;
    int imagearray[]={R.mipmap.intothemist,R.mipmap.ic_launcher};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.button);
        imageview=(ImageView)findViewById(R.id.imageview);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        index=(index+1)%imagearray.length;
        imageview.setImageResource(imagearray[index]);
    }
}
