package com.hhsales.zzxinteyu.hhsales.room_manage.model;

import com.example.lib_common.utils.okhttpUtils.ResultCallback;
import com.hhsales.zzxinteyu.hhsales.bean.ProItemName;
import com.hhsales.zzxinteyu.hhsales.bean.UserPermissions;
import com.hhsales.zzxinteyu.hhsales.room_manage.bean.ProjectBuiding;
import com.hhsales.zzxinteyu.hhsales.room_manage.bean.RoomQuery;

import java.util.Map;

/**
 * Created by Huairen on 2018/9/19.
 */

public interface IRoomQueryModel {
    void findProItemNameByNo501(Map<String, String> map, ResultCallback<ProItemName> resultCallback);

    void findProBuildingByFKProjectId(String project_id, ResultCallback<ProjectBuiding> resultCallback);
    void findRoomByBuildingId(String building_id, ResultCallback<RoomQuery> resultCallback);


    /**
     * 权限检查
     */
    void checkBuildingPermissions(Map<String, String> map, ResultCallback<UserPermissions> resultCallback);

}
