package com.hhsales.zzxinteyu.hhsales.room_manage.bean;

import com.hhsales.zzxinteyu.hhsales.client.bean.PageInfo;

import java.util.ArrayList;

/**
 * Created by acer on 2018/3/31.
 */

public class RoomMagementBases {

    private int resultFlag;

    private ArrayList<RoomMagementBase> data;

    private PageInfo pageInfo;
    private String queryParams;//: null
    private String  roleValue;//: "11111"
    private String  searchRole;//: "查全"
    private String   tempMFile;//: null
    public int getResultFlag() {
        return resultFlag;
    }

    public void setResultFlag(int resultFlag) {
        this.resultFlag = resultFlag;
    }

    public ArrayList<RoomMagementBase> getData() {
        return data;
    }

    public void setData(ArrayList<RoomMagementBase> data) {
        this.data = data;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }
}
