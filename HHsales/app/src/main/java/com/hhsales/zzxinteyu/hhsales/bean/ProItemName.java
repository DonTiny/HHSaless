package com.hhsales.zzxinteyu.hhsales.bean;

import java.util.List;

/**
 * Created by Huairen on 2018/4/25.
 */

public class ProItemName {
    private String message;// ,
    private List<ProItemNameData> data;// [{
    private String queryParams;// null
    private String resultFlag;// 0
    private String roleValue;// "111111"
    private String  searchRole;// "查全"
    private String  tempMFile;// null
    public ProItemName() {
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

    public List<ProItemNameData> getData() {
        return data;
    }

    public void setData(List<ProItemNameData> data) {
        this.data = data;
    }

    public String getQueryParams() {
        return queryParams;
    }

    public void setQueryParams(String queryParams) {
        this.queryParams = queryParams;
    }

    public String getRoleValue() {
        return roleValue;
    }

    public void setRoleValue(String roleValue) {
        this.roleValue = roleValue;
    }

    public String getSearchRole() {
        return searchRole;
    }

    public void setSearchRole(String searchRole) {
        this.searchRole = searchRole;
    }

    public String getTempMFile() {
        return tempMFile;
    }

    public void setTempMFile(String tempMFile) {
        this.tempMFile = tempMFile;
    }
}
