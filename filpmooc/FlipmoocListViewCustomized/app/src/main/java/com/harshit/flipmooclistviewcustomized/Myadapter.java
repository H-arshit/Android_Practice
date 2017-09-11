package com.harshit.flipmooclistviewcustomized;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by User on 27-03-2017.
 */

public class Myadapter extends BaseAdapter {

    private  ArrayList<String> mylisttext;
   private Context context;
    private ArrayList<Integer> mylistimages;

    public Myadapter(Context ctx, ArrayList<String> mytextarray, ArrayList<Integer> myimagearray)
    {
                  context=ctx;
                mylisttext=mytextarray;
                mylistimages=myimagearray;
    }

    @Override
    public int getCount() {
        return mylisttext.size();
    }

    @Override
    public Object getItem(int position) {

        return mylisttext.get(position);
    }

    @Override
    public long getItemId(int position) {

        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View myview= LayoutInflater.from(context).inflate(R.layout.mylistview,parent,false);  // false aive pass kara hai
        TextView mytext=(TextView)myview.findViewById(R.id.mytext);
        CircleImageView myimage=(CircleImageView)myview.findViewById(R.id.myimage);
        mytext.setText(mylisttext.get(position));
        myimage.setImageResource(mylistimages.get(position));
        return myview;
    }
}
