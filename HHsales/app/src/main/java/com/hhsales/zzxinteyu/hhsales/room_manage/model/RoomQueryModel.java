package com.hhsales.zzxinteyu.hhsales.room_manage.model;

import com.example.lib_common.utils.HttpUrl;
import com.example.lib_common.utils.LogUtils;
import com.example.lib_common.utils.okhttpUtils.OkHttpClientManager;
import com.example.lib_common.utils.okhttpUtils.ResultCallback;
import com.hhsales.zzxinteyu.hhsales.bean.ProItemName;
import com.hhsales.zzxinteyu.hhsales.bean.UserPermissions;
import com.hhsales.zzxinteyu.hhsales.room_manage.bean.ProjectBuiding;
import com.hhsales.zzxinteyu.hhsales.room_manage.bean.RoomQuery;

import java.util.Map;

/**
 * Created by Huairen on 2018/9/19.
 */

public class RoomQueryModel implements IRoomQueryModel{
    //查询项目名称
    @Override
    public void findProItemNameByNo501(Map<String, String> map, ResultCallback<ProItemName> resultCallback) {
        OkHttpClientManager.postAsyn(HttpUrl.FIND_PROITEM_Name_BY_NO501,map,resultCallback);
    }

    //根据项目id查询项目楼栋
    @Override
    public void findProBuildingByFKProjectId(String project_id, ResultCallback<ProjectBuiding> resultCallback) {
        OkHttpClientManager.getAsyn(HttpUrl.FIND_PROBUILDING_BY_PROJECTID+"/"+project_id,null,resultCallback);
    }

    //根据楼栋id查询房间信息
    @Override
    public void findRoomByBuildingId(String building_id, ResultCallback<RoomQuery> resultCallback) {
      OkHttpClientManager.getAsyn(HttpUrl.FIND_ROOM_BY_BUILDING_ID+"/"+building_id,null,resultCallback);//HttpUrl.FIND_ROOM_BY_BUILDING_ID+"/"+
    }

    /**
     * 检查权限
     * @param map
     * @param resultCallback
     */
    @Override
    public void checkBuildingPermissions(Map<String, String> map, ResultCallback<UserPermissions> resultCallback) {
        OkHttpClientManager.postAsyn(HttpUrl.FIND_PAGE_PRO_BUILDING_VO, map, resultCallback);
    }

}
