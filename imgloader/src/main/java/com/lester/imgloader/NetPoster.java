package com.lester.imgloader;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NetPoster implements IPost {

    String urlStr;
    ExecutorService executor = Executors.newCachedThreadPool();

    public void setExecutor(ExecutorService executor) {
        this.executor = executor;
    }

    public NetPoster(String urlStr) {
        this.urlStr = urlStr;
    }

    public void setUrlStr(String urlStr) {
        this.urlStr = urlStr;
    }

    @Override
    public void post(final Runnable task) {
        executor.submit(new Runnable() {
            @Override
            public void run() {
                task.run();
            }
        });
    }
}
