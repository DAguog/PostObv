package com.lester.imgloader;

import android.graphics.Bitmap;
import android.widget.ImageView;

public interface ITask extends Runnable {
    String getUrl();
    ImageView getTargetView();
    TaskCallBack getCallBack();

    interface TaskCallBack {
        void CallBack(Bitmap bitmap);
    }
}
