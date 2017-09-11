package com.harshit.flipmoocdifferentimagetutorial;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button getimage;
    ImageView resultimage;
    Integer REQUEST_CAMERA=1,REQUEST_FILE=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getimage=(Button)findViewById(R.id.getimage);
        resultimage=(ImageView)findViewById(R.id.resultimage);


        getimage.setOnClickListener(this);


    }


    // made changes in manifest file also


    @Override
    public void onClick(View v) {

        final String[] menuforalert={"Camera","From Device"};

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Select");
        builder.setCancelable(true);
        builder.setItems(menuforalert, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                if(which==0)
                {


                    Intent cameraintent=new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    if (cameraintent.resolveActivity(getPackageManager()) != null)
                        startActivityForResult(cameraintent,REQUEST_CAMERA);


                }
                else if(which==1)
                {

                    Intent fileintent = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    fileintent.setType("image/*");
                    startActivityForResult(Intent.createChooser(fileintent,"Select File"),REQUEST_FILE);


                }
            }

        });

        builder.show();


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode== Activity.RESULT_OK)
        {
            if(requestCode==REQUEST_FILE)
            {
                Uri selectedimageuri = data.getData();
                resultimage.setImageURI(selectedimageuri);
            }
            else if (requestCode==REQUEST_CAMERA)
            {
                Bundle bundle = data.getExtras();
                final Bitmap image=(Bitmap) bundle.get("data");
                resultimage.setImageBitmap(image);

            }

        }
    }
}
