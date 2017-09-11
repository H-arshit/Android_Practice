package com.harshit.usingloaders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by User on 28-04-2017.
 */

public class AdapterforRecyclerView extends RecyclerView.Adapter<AdapterforRecyclerView.MyadapterHolder> {

    Context context;
    List<Mydata> mylist;

    public AdapterforRecyclerView(Context ctx,List<Mydata> mylist)
    {
        context=ctx;
        this.mylist=mylist;
    }


    @Override
    public MyadapterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater myinflator=LayoutInflater.from(context);
        View myview=myinflator.inflate(R.layout.layoutofeachitem,parent,false);

        return new MyadapterHolder(myview);
    }

    @Override
    public void onBindViewHolder(MyadapterHolder holder, int position) {

        holder.text1.setText(mylist.get(position).getText1());
        holder.text2.setText(mylist.get(position).getText2());

    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }

    public class MyadapterHolder extends RecyclerView.ViewHolder {

        TextView text1,text2;
        public MyadapterHolder(View itemView) {
            super(itemView);
            text1=(TextView)itemView.findViewById(R.id.text1);
            text2=(TextView)itemView.findViewById(R.id.text2);
        }

    }
}
