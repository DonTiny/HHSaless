package com.hhsales.zzxinteyu.hhsales.room_manage.ui;

import com.hhsales.zzxinteyu.hhsales.bean.ProItemName;
import com.hhsales.zzxinteyu.hhsales.room_manage.bean.RoomQuery;

/**
 * Created by Administrator on 2018/11/12.
 */

public interface IRoomQueryView {
    void setRoomQueryData(RoomQuery roomQueryData);
    void initBuilding(String building_id);

    void setProjectName(String projectName,String building_id);

    void firstInitBuilding(String projectName,String buildingName,String building_id);

    //请求失败
    void requestFailed();

    /**
     * 检查权限
     */
    //权限通过
    void permissionsYes();

    //权限不通过
    void permissionsNo();
}
