package com.harshit.loaders;

import android.content.Intent;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    static int iditem=0;
    RecyclerView recyclerView;
    AdapterforRecyclerview adapterforRecyclerview;
    private List<Mydata> mydataList;
    LinearLayoutManager linearLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=(RecyclerView)findViewById(R.id.recyclerviewid);

        mydataList=new ArrayList<>();
        getSupportLoaderManager().initLoader(R.id.loader_id,null,loaderCallbacks);

        adapterforRecyclerview=new AdapterforRecyclerview(mydataList,this);
        recyclerView.setAdapter(adapterforRecyclerview);

        linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if(linearLayoutManager.findLastCompletelyVisibleItemPosition()==mydataList.size()-1)
                {
                    iditem=mydataList.get(mydataList.size()-1).getId();
                    Intent intent= new Intent(LoadFromDataabse.ACTION_BROADCAST);
                    LocalBroadcastManager.getInstance(MainActivity.this).sendBroadcast(intent);

                }
            }

        });

    }
    private LoaderManager.LoaderCallbacks<List<Mydata>> loaderCallbacks=new LoaderManager.LoaderCallbacks<List<Mydata>>() {
        @Override
        public Loader<List<Mydata>> onCreateLoader(int id, Bundle args) {
            return new LoadFromDataabse(getApplicationContext(),iditem);
        }

        @Override
        public void onLoadFinished(Loader<List<Mydata>> loader, List<Mydata> data) {

            if (data!=null) {
                mydataList.clear();
               mydataList.addAll(data);
                adapterforRecyclerview.notifyDataSetChanged();
            }
        }

        @Override
        public void onLoaderReset(Loader<List<Mydata>> loader) {
            iditem=0;
            mydataList=new ArrayList<>();
            adapterforRecyclerview.notifyDataSetChanged();
        }
    };
}
