package com.harshit.connetingtointernet;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button connectbutton,downloadbutton;
    AsyncTaskClass myclass;
    DownloadImageTask mydown;
    static TextView myresult;
    static ImageView imageView;
    ConnectivityManager myconmngr;
    NetworkInfo mynetinfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connectbutton=(Button)findViewById(R.id.connectbutton);
        downloadbutton=(Button)findViewById(R.id.downloadbutton);
        myresult=(TextView)findViewById(R.id.myresult);
        imageView=(ImageView)findViewById(R.id.imageview);

            myconmngr=(ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
            mynetinfo=myconmngr.getActiveNetworkInfo();

        connectbutton.setOnClickListener(this);
        downloadbutton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
       if(v.getId()==R.id.connectbutton) {
           if (mynetinfo!=null && mynetinfo.isConnected()) {
               myclass = new AsyncTaskClass(this);
               myclass.execute("http://www.google.com");
           }
           else
           {
               Toast.makeText(this,"No Internet Access",Toast.LENGTH_SHORT).show();

           }
           }
       else if(v.getId()==R.id.downloadbutton)
       {
            if(mynetinfo!=null && mynetinfo.isConnected())
            {
                mydown=new DownloadImageTask(this);
                mydown.execute("https://i.ytimg.com/vi/YGym1Y0y9j4/hqdefault.jpg");
            }
            else
            {
                Toast.makeText(this,"No Internet Access",Toast.LENGTH_SHORT).show();
            }
       }
    }
}
