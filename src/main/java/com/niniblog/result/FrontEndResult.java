package com.niniblog.result;

import com.google.gson.Gson;

/**
 * 返回前端的数据对象
 */
public class FrontEndResult {
    private Object content;

    private String errorMsg;

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String toString()
    {
        return new Gson().toJson(this);
    }
}
