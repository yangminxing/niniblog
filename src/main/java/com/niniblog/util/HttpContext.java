package com.niniblog.util;

import javax.servlet.http.HttpServletRequest;

/**
 * 后端数据上下文
 */
public class HttpContext {

    public static final String PAGE_INDEX_NAME = "pg_index";
    public static final String PAGE_COUNT_NAME = "pg_count";
    public static final String PAGE_SIZE_NAME = "pg_size";

    /**
     * 当前页序
     */
    public static int getCurrentPageIndex(HttpServletRequest httpServletRequest) {
        try {
            if (httpServletRequest != null && httpServletRequest.getParameter(PAGE_INDEX_NAME) != null)
                return Integer.valueOf(httpServletRequest.getParameter(PAGE_INDEX_NAME));
            return -1;
        } catch (Exception e) {
            return -1;
        }
    }

    /**
     * 页数
     */
    public static int getPageCount(HttpServletRequest httpServletRequest) {
        try {
            if (httpServletRequest != null && httpServletRequest.getParameter(PAGE_COUNT_NAME) != null)
                return Integer.valueOf(httpServletRequest.getParameter(PAGE_COUNT_NAME));
            return -1;
        } catch (Exception e) {
            return -1;
        }
    }

    /**
     * 每页显示数
     */
    public static int getPageSize(HttpServletRequest httpServletRequest) {
        try {
            if (httpServletRequest != null && httpServletRequest.getParameter(PAGE_SIZE_NAME) != null)
                return Integer.valueOf(httpServletRequest.getParameter(PAGE_SIZE_NAME));
            return -1;
        } catch (Exception e) {
            return -1;
        }
    }
}
