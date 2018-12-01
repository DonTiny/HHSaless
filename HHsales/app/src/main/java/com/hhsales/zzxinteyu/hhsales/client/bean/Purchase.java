package com.hhsales.zzxinteyu.hhsales.client.bean;

import java.util.List;

/**
 * Created by Huairen on 2018/5/4.
 */

public class Purchase {
   private String resultFlag;// 0,
    private String          message;// ,
    private List<PurchaseData> data;

    public Purchase() {
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

    public List<PurchaseData> getData() {
        return data;
    }

    public void setData(List<PurchaseData> data) {
        this.data = data;
    }
}
