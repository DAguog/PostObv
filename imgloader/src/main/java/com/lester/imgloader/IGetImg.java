package com.lester.imgloader;

import android.graphics.Bitmap;

public interface IGetImg {

    void getImage(String url,CallBack callBack);

    interface CallBack {
        void bitmap(Bitmap bitmap);
    }

}
