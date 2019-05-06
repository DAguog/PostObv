package com.lester.imgloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;

import java.lang.ref.WeakReference;

public class LoaderTask implements Runnable {

    private String url;
    private View TargetView;
    private IGetImg Engine;
    private TaskCallBack callBack;

    public LoaderTask() {
    }

    public LoaderTask(String url) {
        this.url = url;
    }

    public LoaderTask url(String url) {
        this.url = url;
        return LoaderTask.this;
    }

    public LoaderTask TargetView(View view) {
        this.TargetView = view;
        return LoaderTask.this;
    }

    public LoaderTask setEngine(IGetImg Engine) {
        this.Engine = Engine;
        return LoaderTask.this;
    }

    public LoaderTask setCallBack(TaskCallBack callBack) {
        this.callBack = callBack;
        return LoaderTask.this;
    }

    @Override
    public void run() {
        if (Engine!=null) {
            Engine.getImage(new IGetImg.CallBack() {
                @Override
                public void bitmap(Bitmap bitmap) {
                    callBack.CallBack(bitmap);
                }
            });
        }
    }

    interface TaskCallBack {
        void CallBack(Bitmap bitmap);
    }
}
