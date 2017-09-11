package com.harshit.usingloaders;


        import android.support.v4.app.LoaderManager;
        import android.support.v4.content.Loader;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.support.v7.widget.LinearLayoutManager;
        import android.support.v7.widget.RecyclerView;
        import android.widget.LinearLayout;

        import java.util.ArrayList;
        import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView myrecyclerview;
    AdapterforRecyclerView adapter;

    List<Mydata> mylist;
    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        myrecyclerview=(RecyclerView)findViewById(R.id.myrecyclerview);

        mylist=new ArrayList<>();



        adapter=new AdapterforRecyclerView(this,mylist);

        myrecyclerview.setAdapter(adapter);

        linearLayoutManager=new LinearLayoutManager(this);

        myrecyclerview.setLayoutManager(linearLayoutManager);
        myrecyclerview.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if(linearLayoutManager.findLastCompletelyVisibleItemPosition()== mylist.size()-1)
                    load_get_data_database(mylist.get(mylist.size()-1).getId());
            }
        });



           load_get_data_database(0);




    }

    private void load_get_data_database(final int ide) {


             LoaderManager.LoaderCallbacks<List<Mydata>> loaderCallbacks = new LoaderManager.LoaderCallbacks<List<Mydata>>() {
            @Override
            public Loader<List<Mydata>> onCreateLoader(int id, Bundle args) {
                return new LoaderToLoadFromDatabase(getApplicationContext(), ide , mylist);
            }

            @Override
            public void onLoadFinished(Loader<List<Mydata>> loader, List<Mydata> data) {

                adapter.notifyDataSetChanged();

            }

            @Override
            public void onLoaderReset(Loader<List<Mydata>> loader) {

            }
        };

    }
}
