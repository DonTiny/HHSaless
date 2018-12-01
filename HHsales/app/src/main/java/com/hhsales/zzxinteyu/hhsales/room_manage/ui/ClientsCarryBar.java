package com.hhsales.zzxinteyu.hhsales.room_manage.ui;


import com.hhsales.zzxinteyu.hhsales.room_manage.bean.ProjectList;
import com.hhsales.zzxinteyu.hhsales.room_manage.bean.ProjectNextLevel;
import com.hhsales.zzxinteyu.hhsales.room_manage.bean.RoomMagementBases;

import java.util.List;
import java.util.Map;

/**
 * Created by acer on 2018/3/30.
 */

public interface ClientsCarryBar {

    /**
     * 为桥梁添加Model
     */
    interface Model<T>{
        //查询房间信息
        void queryRoom(boolean load, Map<String, String> parameter, GetRoomData getRoomData);

        interface GetRoomData{
            void getRoomData(boolean internet, RoomMagementBases mRoomBase);
        }
        void getProjectList(GetProjectList getProjectList);
        interface GetProjectList{
            void getProjectList(boolean internet, List<ProjectList> projectLists);
        }

        void getProjectNextLevel(String id, GetProjectNextLevel getProjectNextLevel);
        interface GetProjectNextLevel{
            void getProjectNextLevel(boolean internet, List<ProjectNextLevel> projectLists);
        }

        void getAdvancedSearch(Map<String, String> parameter, GetAdvancedSearch getAdvancedSearch);
        interface GetAdvancedSearch{
            void getAdvancedSearch(boolean internet, RoomMagementBases mRoomBase);
        }
    }
    /**
     * 接口View
     */
    interface View<T>{
        //查询房间信息
        void queryRoom(boolean load, RoomMagementBases queryRooms);

        void networkRequestFailed(String name);

        void getProjectList(List<ProjectList> projectLists);

        void getProjectNextLevel(List<ProjectNextLevel> projectLists, boolean loudongRequest);

        void getAdvancedSearch(RoomMagementBases mRoomBase);

        void selectedRoom(String room_id,String  room_name);
    };

    /**
     * 接口Presenter 是LoginPresenter的所实现类
     */
    interface Presenter{

        // 调用 model的网络请求
        void loadData();
        //查询房间信息
        void queryRoom(boolean load, Map<String, String> parameter);

        void getProjectNextLevel(String id);

        void getProjectList();

        void getAdvancedSearch(Map<String, String> parameter);
    };
}
