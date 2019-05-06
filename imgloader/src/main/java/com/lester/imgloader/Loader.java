package com.lester.imgloader;

import android.content.Context;

public class Loader {

    public static LoaderManager with(Context context) {
        return new LoaderManager(context);
    }

}
