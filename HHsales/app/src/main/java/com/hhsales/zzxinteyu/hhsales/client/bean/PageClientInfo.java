package com.hhsales.zzxinteyu.hhsales.client.bean;

/**
 * Created by Administrator on 2018/4/18 0018.
 */

public class PageClientInfo<T> {
    private int resultFlag;
    private String message;
    private T data;//List<ClientData>/ClientData
    private PageInfo pageInfo;

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public PageClientInfo() {
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getResultFlag() {
        return resultFlag;
    }

    public void setResultFlag(int resultFlag) {
        this.resultFlag = resultFlag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
