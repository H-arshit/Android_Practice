package com.harshit.uploadimageanddatatomysqlserver;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by User on 21-04-2017.
 */

public class SaveData extends AsyncTask<String ,Void,String > {

    Context ctx;
    public SaveData(Context ctx)
    {
        this.ctx=ctx;
    }
    @Override
    protected String doInBackground(String... params) {


        String task=params[0];
        String register="http://10.0.2.2/upload.php";



        if(task.equals("SaveData"))
        {

            try {
                String name=params[1],image=params[2];
                URL url=new URL(register);
                HttpURLConnection mycon=(HttpURLConnection)url.openConnection();
                mycon.setRequestMethod("POST");
                mycon.setDoOutput(true);
                mycon.setDoInput(true);
                OutputStream myoutput=mycon.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(myoutput,"UTF-8"));
                String post_data= URLEncoder.encode("name","UTF-8")+"="+URLEncoder.encode(name,"UTF-8")+"&"+
                        URLEncoder.encode("image","UTF-8")+"="+URLEncoder.encode(image,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                myoutput.close();
                InputStream inputStream=mycon.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result="",line="";
                while((line=bufferedReader.readLine())!=null)
                {
                    result+=line;
                }
                bufferedReader.close();
                inputStream.close();
                mycon.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        Toast.makeText(ctx,s, Toast.LENGTH_SHORT).show();
    }
}
