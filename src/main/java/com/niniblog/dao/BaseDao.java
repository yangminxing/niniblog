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
     * 删除
     */
    public void delete(int id);

    /**
     * 取得id
     */
    public <T> T get(int id);

    /**
     * 获取符合条件的集合
     */
    public List<T> findByExample(T example);

    /**
     * 获取符合条件的第一个数据
     */
    public T findByExampleOne(T example);

    /**
     * 返回符合条件的所有数据
     *
     * @param pageIndex 起始页序
     * @param pageSize 每页显示
     */
    public List<T> findByExample(T example,int pageIndex,int pageSize);
}
