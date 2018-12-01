package com.hhsales.zzxinteyu.hhsales.client.bean;

import java.util.List;

/**
 * Created by Huairen on 2018/4/28.
 */

public class Transaction {
    private String resultFlag;// 0,
    private String message;// ,
    private List<TransactionData> data;//

    public Transaction() {
    }

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

    public List<TransactionData> getData() {
        return data;
    }

    public void setData(List<TransactionData> data) {
        this.data = data;
    }
}
