package com.lester.postobv.app;

import android.app.Application;

import com.lester.baselibrary.AppConfig;
import com.lester.baselibrary.IAppComponent;

public class MainApplication extends Application implements IAppComponent {

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
        for(String component: AppConfig.components) {
            try {
                Class<?> clazz = Class.forName(component);
                Object object = clazz.newInstance();
                if (object instanceof IAppComponent) {
                    ((IAppComponent)object).init(this);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
