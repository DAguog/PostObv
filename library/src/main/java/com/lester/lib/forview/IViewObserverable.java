package com.lester.lib.forview;

import com.lester.lib.base.BaseBody;
import com.lester.lib.core.Observerable;

public interface IViewObserverable<T extends IViewObserver,N extends BaseBody> extends Observerable <T,N>{

    void notifyByDest(Object dest);

    void notifyByChannel(Object channel);

    void notifyByAll(Object body);

}
