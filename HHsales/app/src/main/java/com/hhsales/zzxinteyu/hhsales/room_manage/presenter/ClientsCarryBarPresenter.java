package com.hhsales.zzxinteyu.hhsales.room_manage.presenter;


import com.example.lib_common.mvp.presenter.BasePresenter;
import com.hhsales.zzxinteyu.hhsales.room_manage.bean.ProjectList;
import com.hhsales.zzxinteyu.hhsales.room_manage.bean.ProjectNextLevel;
import com.hhsales.zzxinteyu.hhsales.room_manage.bean.RoomMagementBases;
import com.hhsales.zzxinteyu.hhsales.room_manage.model.ClientsCarryBarModel;
import com.hhsales.zzxinteyu.hhsales.room_manage.ui.ClientsCarryBar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by acer on 2018/3/30.
 */

public class ClientsCarryBarPresenter<T extends ClientsCarryBar.View> extends BasePresenter<ClientsCarryBar.View> implements ClientsCarryBar.Presenter {
    private ClientsCarryBar.View view;
    private ClientsCarryBarModel model = new ClientsCarryBarModel();
    List<String> a = new ArrayList<>();

    public ClientsCarryBarPresenter(ClientsCarryBar.View view) {
        this.view = view;
    }

    @Override
    public void loadData() {
//        view.displayPopWindow(); //把得到的数据返回View层 供Activity用
    }


    /**
     * load:为true表示加载更多
     * @param load
     */
    @Override
    public void queryRoom(final boolean load,Map<String, String> parameter) {
        model.queryRoom(load,parameter, new ClientsCarryBar.Model.GetRoomData() {
            @Override
            public void getRoomData(boolean internet, RoomMagementBases mRoomBase) {
                if (internet) {
                    view.queryRoom(load, mRoomBase);
                } else {
                    view.networkRequestFailed("网络请求");
                }

            }
        });

    }


    @Override
    public void getProjectList() {
        model.getProjectList(new ClientsCarryBar.Model.GetProjectList() {
            @Override
            public void getProjectList(boolean internet, List<ProjectList> projectLists) {
                if (internet) {
                    view.getProjectList(projectLists);
                } else {
                    view.networkRequestFailed("网络请求失败！");
                }
            }
        });
    }

    @Override
    public void getAdvancedSearch(Map<String, String> parameter) {
        model.getAdvancedSearch(parameter, new ClientsCarryBar.Model.GetAdvancedSearch() {
            @Override
            public void getAdvancedSearch(boolean internet, RoomMagementBases mRoomBase) {
                if (internet){
                    view.getAdvancedSearch(mRoomBase);
                }else{
                    view.networkRequestFailed("网络请求失败！");
                }
            }
        });
    }

    @Override
    public void  getProjectNextLevel(String id) {
        model.getProjectNextLevel(id, new ClientsCarryBar.Model.GetProjectNextLevel() {
            @Override
            public void getProjectNextLevel(boolean internet, List<ProjectNextLevel> projectLists) {
                if (internet) {
                    if (projectLists==null){
                        view.getProjectNextLevel(null,false);
                    }else{
                        view.getProjectNextLevel(projectLists,true);
                    }
                } else {
                    view.getProjectNextLevel(null,false);
                }
            }
        });
    }


}
