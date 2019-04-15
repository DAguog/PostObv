package com.lester.lib.core;

import com.lester.lib.base.BaseResult;

/**
 * 观察者
 * @param <T>
 */
public interface Observer<T extends BaseResult> {
    void handle(T result);
}
