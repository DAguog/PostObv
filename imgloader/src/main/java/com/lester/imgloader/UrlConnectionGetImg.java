package com.lester.imgloader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class UrlConnectionGetImg implements IGetImg {

    public UrlConnectionGetImg() {
    }

    @Override
    public void getImage(String urlStr, final CallBack callback) {
        URL url;
        HttpURLConnection connection=null;
        Bitmap bitmap=null;
        try {
            url = new URL(urlStr);
            connection=(HttpURLConnection)url.openConnection();
            connection.setConnectTimeout(6000); //超时设置
            connection.setDoInput(true);
            connection.setUseCaches(false); //设置不使用缓存
            InputStream inputStream=connection.getInputStream();
            bitmap= BitmapFactory.decodeStream(inputStream);
            callback.bitmap(bitmap);
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
