package com.hhsales.zzxinteyu.hhsales.my.bean;

import com.hhsales.zzxinteyu.hhsales.client.bean.PageInfo;

import java.util.List;

/**
 * Created by Administrator on 2018/11/16.
 */

public class MyTaskBean {
    private String advancedQueryList;// null
    private String aopMsg;// null
    private String condition;// ""
    private String fileNameList;// null
    private String message;// ""
    private int moduleNum;// 0
    private int resultFlag;// 0
    private String roleValue;// ""
    private String searchRole;// null
    private String tempMFile;// null
    private List<MyTaskData> data;
    private PageInfo pageInfo;
    private QueryParams queryParams;

    public MyTaskBean() {
    }

    public String getAdvancedQueryList() {
        return advancedQueryList;
    }

    public void setAdvancedQueryList(String advancedQueryList) {
        this.advancedQueryList = advancedQueryList;
    }

    public String getAopMsg() {
        return aopMsg;
    }

    public void setAopMsg(String aopMsg) {
        this.aopMsg = aopMsg;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getFileNameList() {
        return fileNameList;
    }

    public void setFileNameList(String fileNameList) {
        this.fileNameList = fileNameList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getModuleNum() {
        return moduleNum;
    }

    public void setModuleNum(int moduleNum) {
        this.moduleNum = moduleNum;
    }

    public int getResultFlag() {
        return resultFlag;
    }

    public void setResultFlag(int resultFlag) {
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

    public List<MyTaskData> getData() {
        return data;
    }

    public void setData(List<MyTaskData> data) {
        this.data = data;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public QueryParams getQueryParams() {
        return queryParams;
    }

    public void setQueryParams(QueryParams queryParams) {
        this.queryParams = queryParams;
    }
}
