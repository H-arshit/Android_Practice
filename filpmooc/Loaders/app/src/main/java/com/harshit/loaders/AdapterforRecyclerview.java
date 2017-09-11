package com.harshit.loaders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by User on 04-05-2017.
 */

public class AdapterforRecyclerview extends RecyclerView.Adapter<AdapterforRecyclerview.AdapterHolder>{

    List<Mydata> mydataList;
    Context context;


    public AdapterforRecyclerview(List<Mydata> mydataList,Context context)
    {
        this.mydataList=mydataList;
        this.context=context;
    }


    @Override
    public AdapterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.listitemview,parent,false);

        return new AdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterHolder holder, int position) {
    holder.text1.setText(mydataList.get(position).getText1());
        holder.text2.setText(mydataList.get(position).getText2());

    }

    @Override
    public int getItemCount() {
        return mydataList.size();
    }

    public class AdapterHolder extends RecyclerView.ViewHolder{

        TextView text1,text2;
        public AdapterHolder(View itemView) {
            super(itemView);
            text1=(TextView) itemView.findViewById(R.id.text1);
            text2=(TextView) itemView.findViewById(R.id.text2);
        }
    }
}
