package com.niniblog.dao;

import java.util.List;

/**
 * Created by Yang on 2016/5/12.
 */
public interface BaseDao<T> {

    /**
     * 保存
     */
    public <T> void save(T t);


    /**
     * 取得id
     */
    public <T> T get(int id);

}
