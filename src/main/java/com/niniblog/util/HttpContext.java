package com.niniblog.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 后端数据上下文
 */
public class HttpContext {

    public static final String PAGE_INDEX_NAME="pg_index";
    public static final String PAGE_COUNT_NAME="pg_count";
    public static final String PAGE_SIZE_NAME="pg_size";

    /**
     * 当前页序
     */
    private int currentPageIndex;
    /**
     * 页数
     */
    private int pageCount;
    /**
     * 每页显示数
     */
    private int pageSize;

    /**
     *
     */
    private HttpServletRequest httpServletRequest;

    /**
     *
     */
    private HttpServletResponse httpServletResponse;

    public HttpContext(HttpServletRequest request,HttpServletResponse response)
    {
        this.httpServletRequest=request;
        this.httpServletResponse=response;
    }

    public int getCurrentPageIndex() {
        if(httpServletRequest!=null&&httpServletRequest.getParameter(PAGE_INDEX_NAME)!=null)
            return Integer.valueOf(httpServletRequest.getParameter(PAGE_INDEX_NAME));
        return currentPageIndex;
    }

    public void setCurrentPageIndex(int currentPageIndex) {
        this.currentPageIndex = currentPageIndex;
    }

    public int getPageCount() {
        if(httpServletRequest!=null&&httpServletRequest.getParameter(PAGE_COUNT_NAME)!=null)
            return Integer.valueOf(httpServletRequest.getParameter(PAGE_COUNT_NAME));
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageSize() {
        if(httpServletRequest!=null&&httpServletRequest.getParameter(PAGE_SIZE_NAME)!=null)
            return Integer.valueOf(httpServletRequest.getParameter(PAGE_SIZE_NAME));
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
