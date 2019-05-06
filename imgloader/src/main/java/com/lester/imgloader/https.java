package com.lester.imgloader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class https {

    String urlStr;
    String method= "POST";
    String param = "";

    static Handler handler = new Handler(Looper.getMainLooper());

    public https(String urlStr) {
        this.urlStr = urlStr;
    }

    public void doIt(Callback callback) {
        URL url = null;
        HttpURLConnection connection = null;
        StringBuffer buffer = new StringBuffer();
        System.out.println("request:"+urlStr+"?"+param);
        try {
            /*建立连接*/
            url = new URL(urlStr);
            connection = (HttpURLConnection) url.openConnection();

            /*设置连接属性 */
            connection.setDoOutput(true);// 使用 URL 连接进行输出
            connection.setDoInput(true);// 使用 URL 连接进行输入
            connection.setUseCaches(false);// 忽略缓存
            connection.setRequestMethod(method);// 设置URL请求方法

            /*设置请求属性*/
//            connection.setRequestProperty("Content-Length",param.length()+"");
//            connection.setRequestProperty("Content-Type", "application/octet-stream");
//            connection.setRequestProperty("Connection", "Keep-Alive");// 维持长连接
//            connection.setRequestProperty("Charset", "UTF-8");// 设置编码

            /*建立输出流，并写入数据*/
            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(param.getBytes("UTF-8"));

            /*读取数据*/
//            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
//            String line = "";
//            while ((line = reader.readLine()) != null) {
//                buffer.append(line);
//            }
//            reader.close();
//            callback.bitmap(connection.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        System.out.println("response:"+buffer.toString());

    }

    public interface Callback {
        void bitmap(Bitmap stream);
    }

    public void doIt2(final Callback callback) {
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
            final Bitmap finalBitmap = bitmap;
            handler.post(new Runnable() {
                @Override
                public void run() {
                    callback.bitmap(finalBitmap);
                }
            });

            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
