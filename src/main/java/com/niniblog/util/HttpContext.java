package com.niniblog.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * �������������
 */
public class HttpContext {
    /**
     * ��ǰҳ��
     */
    private int currentPageIndex;
    /**
     * ҳ��
     */
    private int pageCount;
    /**
     * ÿҳ��ʾ��
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

    private User 

    public int getCurrentPageIndex() {
        if(httpServletRequest!=null&&httpServletRequest.getParameter("pg_index")!=null)
            return Integer.valueOf(httpServletRequest.getParameter("pg_index"));
        return currentPageIndex;
    }

    public void setCurrentPageIndex(int currentPageIndex) {
        this.currentPageIndex = currentPageIndex;
    }

    public int getPageCount() {
        if(httpServletRequest!=null&&httpServletRequest.getParameter("pg_count")!=null)
            return Integer.valueOf(httpServletRequest.getParameter("pg_count"));
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageSize() {
        if(httpServletRequest!=null&&httpServletRequest.getParameter("pg_size")!=null)
            return Integer.valueOf(httpServletRequest.getParameter("pg_size"));
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
