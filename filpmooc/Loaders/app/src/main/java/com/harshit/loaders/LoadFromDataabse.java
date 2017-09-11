package com.harshit.loaders;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.LocalBroadcastManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class LoadFromDataabse extends AsyncTaskLoader<List<Mydata>> {
    private int id;

    private List<Mydata> mycachelist;

        public static final String ACTION_BROADCAST="com.forceload.onscrollfunction";

    public LoadFromDataabse(Context context,int id ) {
        super(context);
        this.id=id;
        mycachelist=new ArrayList<>();

    }


    @Override
    protected void onStartLoading() {

        LocalBroadcastManager localBroadcastManager=LocalBroadcastManager.getInstance(getContext());
        IntentFilter intentFilter=new IntentFilter(ACTION_BROADCAST);
        localBroadcastManager.registerReceiver(broadcastReceiver,intentFilter);
        if(mycachelist.size()==0)
        {
        forceLoad();}
        else
        {
            super.deliverResult(mycachelist);
        }
    }

    @Override
    public List<Mydata> loadInBackground() {

        OkHttpClient client = new OkHttpClient();
        id=MainActivity.iditem;
        Request request = new Request.Builder().url("http://10.0.2.2/downloadlist.php?id="+id).build();
        try {
            Response response = client.newCall(request).execute();
            JSONArray jsonarray = new JSONArray(response.body().string());
            List<Mydata> mydatas=new ArrayList<>();

            for (int j=0; j<jsonarray.length() ; j++)
            {
                JSONObject object = jsonarray.getJSONObject(j);

                Mydata data=new Mydata(object.getString("type"),object.getString("title"),object.getInt("id"));


                mydatas.add(data);


            }
            return mydatas;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            System.out.println("End of content");
        }finally {

        }

        return null;
    }

    @Override
    public void deliverResult(List<Mydata> data) {
        if (data!=null) {
            mycachelist.addAll(data);
        }
        data = new ArrayList<>();
        data.addAll(mycachelist);

        super.deliverResult(data);
    }

    @Override
    protected void onReset() {
        super.onReset();
        LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(broadcastReceiver);

    }

    private BroadcastReceiver broadcastReceiver= new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            forceLoad();

        }
    };


}
