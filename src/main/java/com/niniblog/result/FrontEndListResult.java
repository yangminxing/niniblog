package com.niniblog.result;

/**
 * 返回前端的综合合集对象
 */
public class FrontEndListResult<T> {

    /**
     * 页号
     */
    private int pgIndex;

    /**
     * 总页数
     */
    private int pgCount;

    /**
     * 每页显示数量
     */
    private int pgSize;

    /**
     * 过滤实体类
     */
    private T t;

    /**
     * 相应正文
     */
    private String html;

    /**
     * 后端错误信息
     */
    private String errorMsg;

    public FrontEndListResult()
    {

    }

    public FrontEndListResult(T t, int pgIndex, int pgCount, int pgSize, String html) {
        this.t=t;
        this.pgIndex = pgIndex;
        this.pgCount = pgCount;
        this.pgSize = pgSize;
        this.html = html;
    }

    public int getPgIndex() {
        return pgIndex;
    }

    public void setPgIndex(int pgIndex) {
        this.pgIndex = pgIndex;
    }

    public int getPgCount() {
        return pgCount;
    }

    public void setPgCount(int pgCount) {
        this.pgCount = pgCount;
    }

    public int getPgSize() {
        return pgSize;
    }

    public void setPgSize(int pgSize) {
        this.pgSize = pgSize;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
