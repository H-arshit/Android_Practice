package com.harshit.asynctasks;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.widget.Toast;

/**
 * Created by User on 26-03-2017.
 */

public class AsyncTaskClass extends AsyncTask<Void,Integer,String> {
    Context mycontext;
    ProgressDialog myprogress;
    public AsyncTaskClass(Context ctx)
    {
        mycontext=ctx;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        myprogress=new ProgressDialog(mycontext);
        myprogress.setTitle("Task is performing");
        myprogress.setMessage("Please wait");
        myprogress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        myprogress.setMax(10);
        myprogress.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                cancel(true);
            }
        });
        myprogress.show();
    }

    @Override
    protected String doInBackground(Void... params) {
        for (int i=1;i<10;i++)
        {
            try {
                Thread.sleep(1000);
                publishProgress(i);
            } catch (InterruptedException e) {
                return "Failed";
            }

        }
        return "Successful";
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        int myval=values[0];
        myprogress.setProgress(myval);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Toast.makeText(mycontext,s,Toast.LENGTH_SHORT).show();
        myprogress.dismiss();
    }
}
