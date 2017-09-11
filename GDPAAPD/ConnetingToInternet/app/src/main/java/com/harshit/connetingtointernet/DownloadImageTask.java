package com.harshit.connetingtointernet;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by User on 02-04-2017.
 */

public class DownloadImageTask extends AsyncTask<String,Void,Bitmap> {
    Context context;
    public DownloadImageTask(Context ctx)
    {
        this.context=ctx;
    }

    @Override
    protected Bitmap doInBackground(String... params) {
       String mystr=params[0];
        InputStream in;
        try {
            URL myurl=new URL(mystr);
            HttpURLConnection myconn=(HttpURLConnection)myurl.openConnection();
            myconn.setConnectTimeout(10000);
            myconn.setReadTimeout(10000);
            myconn.setRequestMethod("GET");
            myconn.connect();
            in=myconn.getInputStream();
            Bitmap mybit= BitmapFactory.decodeStream(in);

            return mybit;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        MainActivity.imageView.setImageBitmap(bitmap);
        super.onPostExecute(bitmap);
    }
}
