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
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editText = (EditText) findViewById(R.id.editText);
        imageView = (ImageView) findViewById(R.id.imageView);

        String videoName1 = Environment.getExternalStorageDirectory().getPath() + "/DCIM/" + editText.getText() + ".mp4";
//        videoView.setVideoURI(Uri.parse(videoName1));



        BitmapPool bitmapPool = Glide.get(getApplicationContext()).getBitmapPool();
        int microSecond = 6000000;// 6th second as an example
        VideoBitmapDecoder videoBitmapDecoder = new VideoBitmapDecoder(microSecond);
        FileDescriptorBitmapDecoder fileDescriptorBitmapDecoder = new FileDescriptorBitmapDecoder(videoBitmapDecoder, bitmapPool, DecodeFormat.PREFER_ARGB_8888);
        Glide.with(getApplicationContext())
                .load(Uri.parse(videoName1))
                .asBitmap()
                .override(50,50)// Example
                .videoDecoder(fileDescriptorBitmapDecoder)
                .into(imageView);

        //        Glide.with(getApplicationContext())
        //                .load(yourUri)
//                .asBitmap()
//                .override(50,50)// Example
//                .videoDecoder(fileDescriptorBitmapDecoder)
//                .into(yourImageView);




    }
}
