package com.harshit.flipmooclistviewcustomized;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView mylist;
   private ArrayList<String> mytextarray;
   private ArrayList<Integer> myimagearray;
   private Myadapter adapt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mytextarray=new ArrayList<>();
        myimagearray=new ArrayList<>();
        additems();
        mylist=(ListView)findViewById(R.id.mylistview);
        adapt=new Myadapter(this,mytextarray,myimagearray);
        mylist.setAdapter(adapt);
    }
    private void additems()
    {
         for(int i=0;i<20;i++)
         mytextarray.add("Harshit "+ i);

             for(int i=0;i<20;i++)
            myimagearray.add(R.drawable.hs);

        return;
    }
}
