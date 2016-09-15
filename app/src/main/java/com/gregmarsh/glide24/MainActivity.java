package com.gregmarsh.glide24;

import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.FileDescriptorBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.VideoBitmapDecoder;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    EditText editText2;
    ImageView imageView;
    ImageView imageView2;
    ImageView imageView3;
    Uri videoUri;
    Uri pictureUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView3 = (ImageView) findViewById(R.id.imageView3);

        String videoName1 = Environment.getExternalStorageDirectory().getPath() + "/DCIM/" + editText.getText() + ".mp4";
        String pictureName = Environment.getExternalStorageDirectory().getPath() + "/DCIM/" + editText2.getText();
        videoUri = Uri.parse(videoName1);
        pictureUri = Uri.parse(pictureName);
//        videoView.setVideoURI(Uri.parse(videoName1));

//        Glide
//                .with(getApplicationContext())
//                .load(videoUri)
//                .into(imageView);

        Glide.with(this).load("http://goo.gl/gEgYUd").into(imageView2);



//        imageView3.setImageResource(R.drawable.mpi1);
        imageView3.setImageURI(pictureUri);


//        BitmapPool bitmapPool = Glide.get(getApplicationContext()).getBitmapPool();
//        int microSecond = 6000000;// 6th second as an example
//        VideoBitmapDecoder videoBitmapDecoder = new VideoBitmapDecoder(microSecond);
//        FileDescriptorBitmapDecoder fileDescriptorBitmapDecoder = new FileDescriptorBitmapDecoder(videoBitmapDecoder, bitmapPool, DecodeFormat.PREFER_ARGB_8888);
//        Glide.with(getApplicationContext())
//                .load(videoUri)
//                .asBitmap()
//                .override(50,50)// Example
//                .videoDecoder(fileDescriptorBitmapDecoder)
//                .into(imageView);

        //        Glide.with(getApplicationContext())
        //                .load(yourUri)
//                .asBitmap()
//                .override(50,50)// Example
//                .videoDecoder(fileDescriptorBitmapDecoder)
//                .into(yourImageView);





    }
}
