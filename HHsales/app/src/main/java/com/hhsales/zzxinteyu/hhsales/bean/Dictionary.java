package com.hhsales.zzxinteyu.hhsales.bean;

/**
 * Created by Huairen on 2018/4/24.
 */

public class Dictionary<T> {
    private String  resultFlag;// 0,
    private String   message;// 查询数据字典明细信息成功,
    private T data;//

    public String getResultFlag() {
        return resultFlag;
    }

    public void setResultFlag(String resultFlag) {
        this.resultFlag = resultFlag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Dictionary() {
    }
}
