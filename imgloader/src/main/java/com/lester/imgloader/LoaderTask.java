package com.lester.imgloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;

import java.lang.ref.WeakReference;

public class LoaderTask implements ITask {

    private String url;
    private ImageView TargetView;
    private IGetImg Engine;
    private ITask.TaskCallBack callBack;

    public LoaderTask() {
    }

    public LoaderTask(String url) {
        this.url = url;
    }

    public LoaderTask url(String url) {
        this.url = url;
        return LoaderTask.this;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public ImageView getTargetView() {
        return TargetView;
    }

    public IGetImg getEngine() {
        return Engine;
    }

    @Override
    public ITask.TaskCallBack getCallBack() {
        return callBack;
    }

    public LoaderTask TargetView(ImageView view) {
        this.TargetView = view;
        return LoaderTask.this;
    }

    public LoaderTask setEngine(IGetImg Engine) {
        this.Engine = Engine;
        return LoaderTask.this;
    }

    public LoaderTask setCallBack(ITask.TaskCallBack callBack) {
        this.callBack = callBack;
        return LoaderTask.this;
    }

    @Override
    public void run() {
        if (Engine!=null) {
            Engine.getImage(url,new IGetImg.CallBack() {
                @Override
                public void bitmap(Bitmap bitmap) {
                    callBack.CallBack(bitmap);
                }
            });
        }
    }


}
