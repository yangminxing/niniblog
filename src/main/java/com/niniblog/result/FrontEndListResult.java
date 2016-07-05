package com.niniblog.result;

/**
 * 返回前端的综合合集对象
 */
public class FrontEndListResult {

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
     * 过滤关键字
     */
    private String fkKeywords;

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

    public FrontEndListResult(int pgIndex, int pgCount, int pgSize, String fkKeywords, String html) {
        this.pgIndex = pgIndex;
        this.pgCount = pgCount;
        this.pgSize = pgSize;
        this.fkKeywords = fkKeywords;
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

    public String getFkKeywords() {
        return fkKeywords;
    }

    public void setFkKeywords(String fkKeywords) {
        this.fkKeywords = fkKeywords;
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
