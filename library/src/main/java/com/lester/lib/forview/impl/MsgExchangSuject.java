package com.lester.lib.forview.impl;

import com.lester.lib.forview.IMsgExchangSubject;
import com.lester.lib.forview.IViewObserverable;
import com.lester.lib.forview.bean.MsgExchangBody;

public class MsgExchangSuject implements IMsgExchangSubject<MsgExchangBody> {

    private IViewObserverable mObserverable;

    public MsgExchangSuject(IViewObserverable observerable) {
        this.mObserverable = observerable;
    }

    @Override
    public void post(MsgExchangBody body) {
        if (body!=null) {

            /**
             * 做一些数据转换
             */

            if (body.dest!=null&&!"".equals(body.dest)) {
                mObserverable.notifyByDest(body);
            } else if (body.Channel!=null&&!"".equals(body.Channel)) {
                mObserverable.notifyByChannel(body);
            } else {
                mObserverable.notifyByAll(body);
            }
        }
    }


}
