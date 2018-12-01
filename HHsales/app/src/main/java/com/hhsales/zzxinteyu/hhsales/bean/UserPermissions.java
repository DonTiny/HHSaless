package com.hhsales.zzxinteyu.hhsales.bean;

/**
 * Created by Administrator on 2018/11/28.
 */

public class UserPermissions {
   private String  queryParams;// null
    private String resultFlag;// 0
    private String roleValue;// "111111111"
    private String searchRole;// "查全"
    private String tempMFile;// null

    public UserPermissions() {
    }

    public String getQueryParams() {
        return queryParams;
    }

    public void setQueryParams(String queryParams) {
        this.queryParams = queryParams;
    }

    public String getResultFlag() {
        return resultFlag;
    }

    public void setResultFlag(String resultFlag) {
        this.resultFlag = resultFlag;
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
