package com.harshit.flipmoocimageinput;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Uri currentimageuri;
    Button chooseimage;
    ImageView outputimage;
    AlertDialog mydialog=null;
    private static final int PICK_FROM_CAMERA=1,PICK_FROM_FILE=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        outputimage=(ImageView)findViewById(R.id.outputimage);
        chooseimage=(Button)findViewById(R.id.chooseimage);
        final String[] menu={"Camera","Device"};
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,android.R.layout.select_dialog_item,menu);
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Select Image");
        builder.setAdapter(adapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                if(which==0)
                {
                    Intent carema=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    File file=new File(Environment.getExternalStorageDirectory(),"databaseimage"+String.valueOf(System.currentTimeMillis())+".jpg");
                    currentimageuri=Uri.fromFile(file);

                    try {


                        carema.putExtra(MediaStore.EXTRA_OUTPUT, currentimageuri);
                        carema.putExtra("return data", true);
                        startActivityForResult(carema, PICK_FROM_CAMERA);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    dialog.cancel();
                }
                else
                {
                    Intent fromdevice=new Intent();
                    fromdevice.setAction(Intent.ACTION_GET_CONTENT);
                    fromdevice.setType("image/*");
                    startActivityForResult(Intent.createChooser(fromdevice,"Complete the step using :"),PICK_FROM_FILE);
                }
            }
        });

        mydialog=builder.create();
        chooseimage.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        mydialog.show();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode!=RESULT_OK)
        {
            return;
        }
        Bitmap myimage=null;
        String path="";
        if(requestCode==PICK_FROM_FILE)
        {
            currentimageuri=data.getData();
            path=getRealPathFromUri(currentimageuri);
            if(path==null)
            {
                path=currentimageuri.getPath();
            }
            if (path!=null)
            {
                myimage= BitmapFactory.decodeFile(path);
            }
        }
        else if(requestCode==PICK_FROM_CAMERA)
        {
            path=currentimageuri.getPath();
            myimage=BitmapFactory.decodeFile(path);
        }
        outputimage.setImageBitmap(myimage);
    }

    public String getRealPathFromUri(Uri contentUri)
    {
        String proj[]={MediaStore.Images.Media.DATA};
        Cursor cursor=managedQuery(contentUri,proj,null,null,null);
        if(cursor==null)
            return null;
        int colindex=cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(colindex);
    }

}
