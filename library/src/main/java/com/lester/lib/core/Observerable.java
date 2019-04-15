package com.lester.lib.core;

/**
 * 被观察者
 * @param <T>
 */
public interface Observerable<T,N> {
    void notify(T who);

    void subScrib(N body);
}
