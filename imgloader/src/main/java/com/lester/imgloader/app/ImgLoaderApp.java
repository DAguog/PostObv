package com.lester.imgloader.app;

import android.app.Application;

import com.lester.baselibrary.IAppComponent;

public class ImgLoaderApp extends Application implements IAppComponent {

    private static Application application;

    public static Application getApplication() {
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        init(this);
    }

    @Override
    public void init(Application application) {
        this.application = application;
    }
}
