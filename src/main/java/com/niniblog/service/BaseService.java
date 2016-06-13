package com.niniblog.service;

import java.util.List;

/**
 * ��������ӿ�
 */
public interface BaseService<T> {
    public void save(T t);
    public T get(int id);
    public List<T> findByExample(T example);
    public List<T> findByExample(T example,int index,int size);
}

