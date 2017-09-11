package com.harshit.usingloaders;

import android.content.Context;
import android.support.v4.content.Loader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by User on 29-04-2017.
 */

public class UsingLoader extends Loader<List<Mydata>> {

    private int id;
    List<Mydata> mylistcache;
    public UsingLoader(Context context ,int id) {
        super(context);
        this.id=id;

    }

    @Override
    protected void onStartLoading() {
     if(mylistcache==null)
     {
        forceLoad();
     }
     else
     {
         super.deliverResult(mylistcache);
     }


    }

    @Override
    protected void onForceLoad() {
        super.onForceLoad();
        OkHttpClient client=  new OkHttpClient();
        Request request=new Request.Builder().url("http://10.0.2.2/downloadlist.php?id="+id).build();

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
          deliverResult(mylistcache);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            System.out.println("No more data left");
        }
    }

    @Override
    protected void onReset() {
        super.onReset();
    }

    @Override
    public void deliverResult(List<Mydata> data) {
        mylistcache=data;
        if (isStarted())
        super.deliverResult(data);
    }
}
