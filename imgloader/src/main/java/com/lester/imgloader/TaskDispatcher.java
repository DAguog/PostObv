package com.lester.imgloader;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class TaskDispatcher {

    public static volatile TaskDispatcher instance;

    public static ExecutorService executor = Executors.newCachedThreadPool();

    private TaskDispatcher(){}

    public static TaskDispatcher getInstance() {

        if (instance==null) {
            synchronized (TaskDispatcher.class) {
                if (instance==null) {
                    instance = new TaskDispatcher();
                }
            }
        }
        return instance;
    }

    public void dispatch(LoaderTask task) {

    }

}
