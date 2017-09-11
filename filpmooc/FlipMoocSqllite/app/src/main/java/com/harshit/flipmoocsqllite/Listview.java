package com.harshit.flipmoocsqllite;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class Listview extends AppCompatActivity {
    MySqlLiteDataBase mydatabase;
    ListView mylist;
    ListAdapter myadapt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        mydatabase=MainActivity.mydatabase;
        Cursor res=mydatabase.getAllData();
        mylist=(ListView)findViewById(R.id.mylistview);
        myadapt=new ListAdapter(this,res);
        mylist.setAdapter(myadapt);
    }
}
