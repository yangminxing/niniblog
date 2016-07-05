package com.niniblog.result;

import java.util.List;

/**
 * 数据层返回的结果对象
 */
public class DaoListResult<T> {

    /**
     * 返回的对象业务集合
     */
    private List<T> daoList;

    /**
     * 返回的总行数
     */
    private int rowCount;

    public DaoListResult(List<T> daoList, int rowCount) {
        this.daoList = daoList;
        this.rowCount = rowCount;
    }

    public List<T> getDaoList() {
        return daoList;
    }

    public void setDaoList(List<T> daoList) {
        this.daoList = daoList;
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }
}
