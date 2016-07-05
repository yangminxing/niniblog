package com.niniblog.service;

import com.niniblog.result.DaoListResult;

import java.util.List;

/**
 * 基本服务接口
 */
public interface BaseService<T> {
    public void save(T t);
    public T get(int id);
    public DaoListResult<T> findByExample(T example);
    public DaoListResult<T> findByExample(T example,int index,int size);
}

