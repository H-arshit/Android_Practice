package com.harshit.connetingtointernet;

import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by User on 02-04-2017.
 */

public class AsyncTaskClass extends AsyncTask<String,Void,String> {
    Context ctx;
    public AsyncTaskClass(Context ctx)
    {
        this.ctx=ctx;
    }
    @Override
    protected String doInBackground(String... params) {
        String s=params[0];
        InputStream in;
        try {
            URL myurl=new URL(s);
            HttpURLConnection mycon=(HttpURLConnection)myurl.openConnection();
            mycon.setConnectTimeout(20000);
            mycon.setReadTimeout(20000);
            mycon.setRequestMethod("GET");
            mycon.connect();
            in=mycon.getInputStream();
            BufferedReader mybuf=new BufferedReader(new InputStreamReader(in));
            StringBuilder mybuilderstring=new StringBuilder();
            String line="";
            while((line=mybuf.readLine())!=null)
            {
                mybuilderstring.append(line+" \n");
            }
            mybuf.close();
            in.close();
            return mybuilderstring.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }



        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        MainActivity.myresult.setText(s);
    }
}
