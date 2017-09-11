package com.harshit.flipmooclistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
     ListView mylistView;
    private static  String listelements[]={"Harshit","Nidanshu","Anany","Jalaj","Aditi"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mylistView=(ListView)findViewById(R.id.listview);
        createmelist();
        mylistView.setOnItemClickListener(this);

    }
    public void createmelist()
    {
        ArrayAdapter<String> myadapter=new ArrayAdapter<>(this,R.layout.listofnames,listelements);
        mylistView.setAdapter(myadapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String values=(String) mylistView.getItemAtPosition(position);
        Toast.makeText(this,"Position: "+position+" Value: "+values,Toast.LENGTH_SHORT).show();
    }
}
