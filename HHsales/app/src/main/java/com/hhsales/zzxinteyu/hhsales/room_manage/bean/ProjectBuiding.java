package com.hhsales.zzxinteyu.hhsales.room_manage.bean;

import com.hhsales.zzxinteyu.hhsales.client.bean.PageInfo;

import java.util.List;

/**
 * Created by Administrator on 2018/11/14.
 */

public class ProjectBuiding {
    private String advancedQueryList;// null
    private String aopMsg;// null
    private String condition;// ""
    private String fileNameList;// null
    private String message;// ""
    private int moduleNum;// 0
    private String queryParams;// null
    private int resultFlag;// 0
    private String roleValue;// "1111"
    private String searchRole;// null
    private String tempMFile;// null
    private PageInfo pageInfo;
    private List<Building> data;

    public String getAdvancedQueryList() {
        return advancedQueryList;
    }

    public List<Building> getData() {
        return data;
    }

    public void setData(List<Building> data) {
        this.data = data;
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

    public String getQueryParams() {
        return queryParams;
    }

    public void setQueryParams(String queryParams) {
        this.queryParams = queryParams;
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

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }
}
