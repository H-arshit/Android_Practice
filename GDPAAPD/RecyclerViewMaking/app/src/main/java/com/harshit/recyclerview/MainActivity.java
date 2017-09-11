package com.harshit.recyclerview;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView myrecyclerview;
    String str1[],str2[];
    MyadapterforRecyclerView adapt;

    private List<Mydata> mylist;

    LinearLayoutManager linearmanager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        myrecyclerview=(RecyclerView)findViewById(R.id.myrecyclerview);

        mylist=new ArrayList<>();

        load_data_from_server(0);

        adapt=new MyadapterforRecyclerView(this,mylist);
        myrecyclerview.setAdapter(adapt);

       linearmanager=new LinearLayoutManager(this);

        myrecyclerview.setLayoutManager(linearmanager);
        myrecyclerview.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if(linearmanager.findLastCompletelyVisibleItemPosition()== mylist.size()-1)
                load_data_from_server(mylist.get(mylist.size()-1).getId());
            }
        });
    }

    private void load_data_from_server(final int ide) {

    AsyncTask<Integer,Void,Void>  task = new AsyncTask<Integer, Void, Void>() {
        @Override
        protected Void doInBackground(Integer... params) {

            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url("http://10.0.2.2/downloadlist.php?id="+ide).build();
            try {
                Response response = client.newCall(request).execute();

                JSONArray jsonarray = new JSONArray(response.body().string());

                for (int j=0; j<jsonarray.length() ; j++)
                {
                    JSONObject object = jsonarray.getJSONObject(j);

                    Mydata data=new Mydata(object.getString("type"),object.getString("title"),object.getInt("id"));


                    mylist.add(data);


                }


            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                System.out.println("End of content");
            }


            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {

            adapt.notifyDataSetChanged();
        }
    };

    task.execute(ide);

    }
}
