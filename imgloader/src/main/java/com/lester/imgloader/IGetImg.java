package com.lester.imgloader;

import android.graphics.Bitmap;

public interface IGetImg {

    void getImage(CallBack callBack);

    interface CallBack {
        void bitmap(Bitmap bitmap);
    }

}
