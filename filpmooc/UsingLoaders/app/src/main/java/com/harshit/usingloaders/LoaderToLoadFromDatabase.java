package com.harshit.usingloaders;


import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class LoaderToLoadFromDatabase extends AsyncTaskLoader<List<Mydata>> {
    int ide=0;
    List<Mydata> mylist,mylistcache;
    public LoaderToLoadFromDatabase(Context context , int ide) {
        super(context);
        this.ide=ide;
        this.mylist=mylist;

    }

    @Override
    protected void onStartLoading() {
        if(mylistcache==null)
        forceLoad();
        else
            super.deliverResult(mylistcache);
    }


    @Override
    public List<Mydata> loadInBackground() {




        OkHttpClient client=  new OkHttpClient();
        Request request=new Request.Builder().url("http://10.0.2.2/downloadlist.php?id="+ide).build();

        try {
            Response response=client.newCall(request).execute();

            JSONArray jsonarray = new JSONArray(response.body().string());

            mylistcache=new ArrayList<>();

            for (int j=0; j<jsonarray.length() ; j++)
            {
                JSONObject object = jsonarray.getJSONObject(j);

                Mydata data=new Mydata(object.getString("type"),object.getString("title"),object.getInt("id"));

                mylistcache.add(data);


            }
            return mylistcache;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    public void deliverResult(List<Mydata> data) {
        if (data!=null)
        mylistcache.addAll(data);
        super.deliverResult(data);
    }
}
