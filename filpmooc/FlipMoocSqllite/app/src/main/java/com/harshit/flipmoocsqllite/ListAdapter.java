package com.harshit.flipmoocsqllite;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by User on 05-04-2017.
 */

public class ListAdapter extends BaseAdapter {
    Context context;
    Cursor alldata;

    public ListAdapter(Context ctx, Cursor res)
    {
            context=ctx;
            alldata=res;

    }

    @Override
    public int getCount() {
        return alldata.getCount();
    }

    @Override
    public Object getItem(int position) {
        return alldata.getString(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View myview= LayoutInflater.from(context).inflate(R.layout.listviewlayout,parent,false);

        TextView name,exp,sal;
        name=(TextView)myview.findViewById(R.id.name);
        exp=(TextView)myview.findViewById(R.id.exp);
        sal=(TextView)myview.findViewById(R.id.sal);
        name.setText(alldata.getString(0));
        exp.setText(alldata.getString(1));
        sal.setText(alldata.getString(2));
        return myview;
    }
}
