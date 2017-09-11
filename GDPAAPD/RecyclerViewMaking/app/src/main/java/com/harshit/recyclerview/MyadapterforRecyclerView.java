package com.harshit.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by User on 22-03-2017.
 */

public class MyadapterforRecyclerView  extends RecyclerView.Adapter<MyadapterforRecyclerView.MyadapterHolder>
{
    List<Mydata> mydata;
    Context mycontext;
    public MyadapterforRecyclerView(Context ctx, List<Mydata> mydata)
    {
            mycontext=ctx;
            this.mydata=mydata;
    }

    @Override
    public MyadapterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater myinflater=LayoutInflater.from(mycontext);
        View myview=myinflater.inflate(R.layout.viewforeachrow,parent,false);

        return new MyadapterHolder(myview);
    }

    @Override
    public void onBindViewHolder(MyadapterHolder holder, int position) {
        holder.textbelow.setText(mydata.get(position).getText1());
        holder.textup.setText(mydata.get(position).getText2());

    }

    @Override
    public int getItemCount() {
        return mydata.size();
    }

    public class MyadapterHolder extends RecyclerView.ViewHolder {
        TextView textbelow,textup;
        public MyadapterHolder(View itemView)
        {
            super(itemView);
            textbelow=(TextView)itemView.findViewById(R.id.textbelow);
            textup=(TextView)itemView.findViewById(R.id.textup);
        }
    }
}
