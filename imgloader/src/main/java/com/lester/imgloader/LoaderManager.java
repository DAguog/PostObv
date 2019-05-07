package com.lester.imgloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;

import java.lang.ref.WeakReference;

public class LoaderManager {

    private WeakReference<Context> contextWeakReference;

    private String imgUrl;
    private IGetImg GetImgEngine;
    private WeakReference<ImageView> viewWeakReference;
    private IPost poster;

    static Handler handler = new Handler(Looper.getMainLooper());

    public LoaderManager setTargetView(ImageView targetView) {
        viewWeakReference = new WeakReference<>(targetView);
        return LoaderManager.this;
    }

    public LoaderManager(Context context) {
        contextWeakReference = new WeakReference<>(context);
    }

    public LoaderManager setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        this.poster = NetPoster.getInstance();
        this.GetImgEngine = new UrlConnectionGetImg();
        return LoaderManager.this;
    }

    private void setPoster(IPost poster) {
        this.poster = poster;
    }

    private void setGetImgEngine(IGetImg getImgEngine) {
        GetImgEngine = getImgEngine;
    }

    public void load() {
        LoaderTask loaderTask = new LoaderTask()
                .url(imgUrl)
                .setEngine(GetImgEngine)
                .setCallBack(new LoaderTask.TaskCallBack() {
                    @Override
                    public void CallBack(final Bitmap bitmap) {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                if (viewWeakReference!=null&&viewWeakReference.get()!=null) {
                                    viewWeakReference.get().setImageBitmap(bitmap);
                                }
                            }
                        });
                    }
                });

        poster.post(loaderTask);
    }
}
