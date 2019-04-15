package com.lester.lib.forview.impl;

import com.lester.lib.forview.IMsgExchangSubject;
import com.lester.lib.forview.IViewObserverable;
import com.lester.lib.forview.bean.MsgExchangBody;
import com.lester.lib.forview.bean.ViewMsgResult;

public class ViewObserverable implements IViewObserverable<ViewObserver, MsgExchangBody> {

    private static volatile ViewObserverable mInstance;

    private static MsgExchangSuject msgExchangSuject;

    private ViewObserverable(){}

    public static ViewObserverable getInstance() {
        if (mInstance==null) {
            synchronized (ViewObserverable.class) {
                if (mInstance==null) {
                    mInstance = new ViewObserverable();
                }
            }
        }

        if (msgExchangSuject==null) {
            msgExchangSuject = new MsgExchangSuject(mInstance);
        }

        return mInstance;
    }



    @Override
    public void notifyByDest(Object dest) {

    }

    @Override
    public void notifyByChannel(Object channel) {

    }

    @Override
    public void notifyByAll(Object body) {

    }

    @Override
    public void notify(ViewObserver who) {

    }

    @Override
    public void subScrib(MsgExchangBody body) {
        msgExchangSuject.post(body);
    }

    private void notify(ViewObserver who,ViewMsgResult result) {

    }
}
