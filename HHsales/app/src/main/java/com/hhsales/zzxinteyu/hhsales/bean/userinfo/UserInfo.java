package com.hhsales.zzxinteyu.hhsales.bean.userinfo;

import com.hhsales.zzxinteyu.hhsales.client.bean.PageInfo;

import java.util.List;

/**
 * Created by Administrator on 2018/11/2.
 */

public class UserInfo {
    private int resultFlag;
    private String message;// 查询我的用户信息成功,
    private String tempMFile;// null,
    private String fileNameList;// null,
    private String roleValue;// 111111,
    private String searchRole;// null,
    private String advancedQueryList;// null,
    private String queryParams;// null,
    private String condition;// ,
    private String aopMsg;// null,
    private int moduleNum;// 0

    private List<UserInfoData> data;
    private PageInfo pageInfo;

    public UserInfo() {
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

    public String getTempMFile() {
        return tempMFile;
    }

    public void setTempMFile(String tempMFile) {
        this.tempMFile = tempMFile;
    }

    public String getFileNameList() {
        return fileNameList;
    }

    public void setFileNameList(String fileNameList) {
        this.fileNameList = fileNameList;
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

    public String getAdvancedQueryList() {
        return advancedQueryList;
    }

    public void setAdvancedQueryList(String advancedQueryList) {
        this.advancedQueryList = advancedQueryList;
    }

    public String getQueryParams() {
        return queryParams;
    }

    public void setQueryParams(String queryParams) {
        this.queryParams = queryParams;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getAopMsg() {
        return aopMsg;
    }

    public void setAopMsg(String aopMsg) {
        this.aopMsg = aopMsg;
    }

    public int getModuleNum() {
        return moduleNum;
    }

    public void setModuleNum(int moduleNum) {
        this.moduleNum = moduleNum;
    }

    public List<UserInfoData> getData() {
        return data;
    }

    public void setData(List<UserInfoData> data) {
        this.data = data;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }
}
