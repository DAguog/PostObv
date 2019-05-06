package com.lester.imgloader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.InputStream;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.image);
        String url = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1556600319253&di=bdeea4309a607390b99553583cee5e38&imgtype=0&src=http%3A%2F%2Fhbimg.b0.upaiyun.com%2F3da564f6b091e4886fa4b3d84a3e56f2af6337fe63a4-fnOcRo_fw658";

        Loader.with(this)
                .setImgUrl(url)
                .setTargetView(imageView)
                .load();
    }
}
