package com.lester.lib.callbacks;

import com.lester.lib.error.ErrorMsg;

public interface ICallback<T> {

    void onSuccess(T correctMsg);

    void onFail(ErrorMsg errorMsg);

}
