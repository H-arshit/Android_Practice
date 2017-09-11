package com.harshit.asynctasksloader;

import android.app.ProgressDialog;
import android.content.AsyncTaskLoader;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by User on 27-03-2017.
 */

public class AsyncLoaderProcessClass extends AsyncTaskLoader<> {

    Context ctx;
    ProgressDialog myprog;

    public AsyncLoaderProcessClass(Context context) {
        super(context);
        ctx=context;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        myprog=new ProgressDialog(ctx);
        myprog.setTitle("Async Task Loader Task Loading");
        myprog.setMessage("Task is performing");
        myprog.setMax(10);
        myprog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        myprog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();

                }
        });
        myprog.show();
    }

    @Override
    public Void loadInBackground() {
        return null;
    }

    @Override
    protected void onStopLoading() {
        super.onStopLoading();
    }
}
