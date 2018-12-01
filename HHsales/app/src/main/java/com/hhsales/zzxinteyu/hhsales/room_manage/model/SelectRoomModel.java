package com.hhsales.zzxinteyu.hhsales.room_manage.model;

import com.example.lib_common.utils.HttpUrl;
import com.example.lib_common.utils.LogUtils;
import com.example.lib_common.utils.okhttpUtils.GsonUtil;
import com.example.lib_common.utils.okhttpUtils.OkHttpClientManager;
import com.example.lib_common.utils.okhttpUtils.ResultCallback;
import com.hhsales.zzxinteyu.hhsales.bean.ProItemName;
import com.hhsales.zzxinteyu.hhsales.room_manage.bean.ProjectBuiding;
import com.hhsales.zzxinteyu.hhsales.room_manage.bean.RoomQuery;
import com.hhsales.zzxinteyu.hhsales.room_manage.interfaces.ISelectRoom;

import java.util.Map;

/**
 * Created by Administrator on 2018/11/21.
 */

public class SelectRoomModel implements ISelectRoom.Model {


    @Override
    public void findProItemNameByNo501(Map map, ResultCallback resultCallback) {
        OkHttpClientManager.postAsyn(HttpUrl.FIND_PROITEM_Name_BY_NO501,map,resultCallback);

    }

    @Override
    public void findProBuildingByFKProjectId(String project_id, ResultCallback resultCallback) {
        OkHttpClientManager.getAsyn(HttpUrl.FIND_PROBUILDING_BY_PROJECTID+"/"+project_id,null,resultCallback);

    }

    @Override
    public void findPageProRoomByBuildingId(Map map, ResultCallback resultCallback) {
        OkHttpClientManager.postAsyn(HttpUrl.FIND_PAGE_PRO_ROOM, map, resultCallback);
        LogUtils.i("当前请求参数"+ GsonUtil.GsonString(map));


    }


}
