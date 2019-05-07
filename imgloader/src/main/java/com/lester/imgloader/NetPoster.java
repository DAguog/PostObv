package com.lester.imgloader;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NetPoster implements IPost {

    ExecutorService executor = Executors.newCachedThreadPool();

    private static volatile NetPoster instance = null;

    public static NetPoster getInstance() {
        if (instance==null) {
            synchronized (NetPoster.class) {
                if (instance==null) {
                    instance = new NetPoster();
                }
            }
        }
        return instance;
    }

    public void setExecutor(ExecutorService executor) {
        this.executor = executor;
    }

    private NetPoster() {
    }

    @Override
    public void post(final ITask task) {

        executor.submit(new Runnable() {
            @Override
            public void run() {
                task.run();
            }
        });
    }
}
