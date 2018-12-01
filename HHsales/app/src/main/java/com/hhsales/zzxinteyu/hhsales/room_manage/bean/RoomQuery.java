package com.hhsales.zzxinteyu.hhsales.room_manage.bean;

import com.hhsales.zzxinteyu.hhsales.client.bean.PageInfo;

/**
 * Created by Administrator on 2018/11/13.
 */

public class RoomQuery {
    private  String advancedQueryList;// null
    private  String   aopMsg;// null
    private  String  condition;// ""
    private  RoomData  data;// {building;// {building_id;// "e9f698ce-478b-4f65-8269-e322d9c3f970",…},…}
    private  String  fileNameList;// null
    private  String  message;// ""
    private  int  moduleNum;// 0
    private  PageInfo pageInfo;// {cpage;// 1, page_size;// 30, total_page;// 1, total_count;// 0, index_count;// 0, isnext;// false,…}
    private  String   queryParams;// null
    private  int   resultFlag;// 0
    private  String   roleValue;// "11111"
    private  String  searchRole;// "查全"
    private  String   tempMFile;// null

    public RoomQuery() {
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

    public RoomData getData() {
        return data;
    }

    public void setData(RoomData data) {
        this.data = data;
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

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
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
}
