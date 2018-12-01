package com.hhsales.zzxinteyu.hhsales.room_manage.interfaces;

import com.example.lib_common.utils.okhttpUtils.ResultCallback;
import com.hhsales.zzxinteyu.hhsales.bean.ProItemName;
import com.hhsales.zzxinteyu.hhsales.room_manage.bean.ProjectBuiding;
import com.hhsales.zzxinteyu.hhsales.room_manage.bean.ProjectList;
import com.hhsales.zzxinteyu.hhsales.room_manage.bean.ProjectNextLevel;
import com.hhsales.zzxinteyu.hhsales.room_manage.bean.RoomMagementBases;
import com.hhsales.zzxinteyu.hhsales.room_manage.bean.RoomQuery;
import com.hhsales.zzxinteyu.hhsales.room_manage.ui.ClientsCarryBar;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/11/21.
 */

public interface ISelectRoom {
    /**
     * 为桥梁添加Model
     */
    interface Model<T>{
        void findProItemNameByNo501(Map<String, String> map, ResultCallback<ProItemName> resultCallback);

        void findProBuildingByFKProjectId(String project_id, ResultCallback<ProjectBuiding> resultCallback);
        void findPageProRoomByBuildingId(Map<String,String> map ,ResultCallback<RoomMagementBases> resultCallback);
    }
    /**
     * 接口View
     */
    interface View<T>{
        void showError();
        void showLoading();
        void showSuccess();
        void showEmpty();
        void firstInitBuilding(String projectName,String buildingName,String building_id);
        void setPageRoomData(RoomMagementBases roomData);
        void setProjecTName(String projectName,String buildingName);

        void selectedRoom(String room_id, String room_name);
        void initializei();

    };

    /**
     * 接口Presenter 是LoginPresenter的所实现类
     */
    interface Presenter{

    };
}
