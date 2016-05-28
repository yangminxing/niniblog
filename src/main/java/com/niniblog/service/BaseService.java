package com.niniblog.service;

/**
 * Created by lenovo on 2016/5/15.
 */
public interface BaseService<T> {
    public void save(T t);
    public T get(int id);
}

