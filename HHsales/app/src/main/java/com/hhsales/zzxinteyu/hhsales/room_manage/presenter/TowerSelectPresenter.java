package com.hhsales.zzxinteyu.hhsales.room_manage.presenter;

import com.example.lib_common.mvp.presenter.BasePresenter;
import com.example.lib_common.utils.LogUtils;
import com.example.lib_common.utils.okhttpUtils.ResultCallback;
import com.hhsales.zzxinteyu.hhsales.bean.ProItemName;
import com.hhsales.zzxinteyu.hhsales.room_manage.bean.Building;
import com.hhsales.zzxinteyu.hhsales.room_manage.bean.ProjectBuiding;
import com.hhsales.zzxinteyu.hhsales.room_manage.model.IRoomQueryModel;
import com.hhsales.zzxinteyu.hhsales.room_manage.model.RoomQueryModel;
import com.hhsales.zzxinteyu.hhsales.room_manage.ui.ITowerSelectView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Request;

/**
 * Created by Administrator on 2018/11/14.
 */

public class TowerSelectPresenter extends BasePresenter<ITowerSelectView> {
    private IRoomQueryModel iRoomQueryModel = new RoomQueryModel();
    private Map<String, List<Building>> mapList;
    private  ProItemName proItemName;
    private int index;
    private int size;
    public void getProItemName(){
        iRoomQueryModel.findProItemNameByNo501(null, new ResultCallback<ProItemName>() {
            @Override
            public void onError(Request request, Exception e) {
                LogUtils.i("获取项目名称失败"+e);
                mViewRef.get().showToast("请检查网络连接");
            }

            @Override
            public void onResponse(ProItemName response) throws Exception {
                LogUtils.i("获取项目名称成功"+response);
                mViewRef.get().initNode(response);
                mapList = new HashMap<>();
                index=0;
                size = response.getData().size();
                proItemName = response;
                getProBuildingByFKProjectId(proItemName.getData().get(0).getProject_id());
            }
        });

    }

    public void getProBuildingByFKProjectId(final String project_id){
        iRoomQueryModel.findProBuildingByFKProjectId(project_id, new ResultCallback<ProjectBuiding>() {
            @Override
            public void onError(Request request, Exception e) {
                LogUtils.i("按项目id查询项目楼栋失败"+e);
                mViewRef.get().showToast("请检查网络连接");

            }

            @Override
            public void onResponse(ProjectBuiding response) throws Exception {
//                LogUtils.i("按项目id查询项目楼栋成功"+response);
                 for (int i=0;i<response.getData().size();i++){
                     mapList.put(project_id, response.getData());
                 }
                index++;
                if(index==size){

                    mViewRef.get().initBuiding(mapList);
                }else {
                    getProBuildingByFKProjectId(proItemName.getData().get(index).getProject_id());
                }
            }
        });

    }
}
