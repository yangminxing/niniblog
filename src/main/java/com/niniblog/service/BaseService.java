package com.niniblog.service;

import java.util.List;

/**
 * 基本服务接口
 */
public interface BaseService<T> {
    public void save(T t);
    public T get(int id);
    public List<T> findByExample(T example);
    public List<T> findByExample(T example,int index,int size);
}

