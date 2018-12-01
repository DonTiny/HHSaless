package com.hhsales.zzxinteyu.hhsales.room_manage.presenter;

import com.example.lib_common.mvp.presenter.BasePresenter;
import com.example.lib_common.utils.LogUtils;
import com.example.lib_common.utils.okhttpUtils.GsonUtil;
import com.example.lib_common.utils.okhttpUtils.ResultCallback;
import com.hhsales.zzxinteyu.hhsales.bean.ProItemName;
import com.hhsales.zzxinteyu.hhsales.room_manage.bean.ProjectBuiding;
import com.hhsales.zzxinteyu.hhsales.room_manage.bean.RoomMagementBases;
import com.hhsales.zzxinteyu.hhsales.room_manage.bean.RoomQuery;
import com.hhsales.zzxinteyu.hhsales.room_manage.interfaces.ISelectRoom;
import com.hhsales.zzxinteyu.hhsales.room_manage.model.SelectRoomModel;

import java.util.Map;

import okhttp3.Request;

/**
 * Created by Administrator on 2018/11/21.
 */

public class SelectRoomPresenter extends BasePresenter<ISelectRoom.View> implements ISelectRoom.Presenter {


    private ISelectRoom.Model selectRoomModel = new SelectRoomModel();
    private int project_index;
    private ProItemName proItemName;

    public SelectRoomPresenter() {


    }

    public void getProItemName() {
        selectRoomModel.findProItemNameByNo501(null, new ResultCallback<ProItemName>() {
            @Override
            public void onError(Request request, Exception e) {
                LogUtils.i("获取项目名称失败" + e);
                mViewRef.get().showError();
            }

            @Override
            public void onResponse(ProItemName response) throws Exception {
                LogUtils.i("获取项目名称成功" + response);
                proItemName = response;
                project_index = 0;
                findProBuildingByFKProjectId(proItemName.getData().get(project_index).getProject_id());

            }
        });

    }

    //根据项目id查询楼栋
    private void findProBuildingByFKProjectId(final String project_id) {
        selectRoomModel.findProBuildingByFKProjectId(project_id, new ResultCallback<ProjectBuiding>() {
            @Override
            public void onError(Request request, Exception e) {
                LogUtils.i("根据项目id查询楼栋信息失败");
                mViewRef.get().showError();

            }

            @Override
            public void onResponse(ProjectBuiding response) throws Exception {
                LogUtils.i("根据项目id查询楼栋信息成功");
                if (response.getData().size() > 0) {
                    mViewRef.get().firstInitBuilding(proItemName.getData().get(project_index).getItem_name(), response.getData().get(0).getName(), response.getData().get(0).getBuilding_id());
                    project_index = -1;
                    LogUtils.i("楼栋大于1");
                } else if (project_index != -1) {
                    project_index++;
                    findProBuildingByFKProjectId(proItemName.getData().get(project_index).getProject_id());
                    LogUtils.i("楼栋小于1");

                }

            }
        });

    }

    //根据楼栋id分页查询房间信息
    public void findPageProRoomByBuildingId( Map<String,String> map) {
        selectRoomModel.findPageProRoomByBuildingId(map, new ResultCallback<RoomMagementBases>() {
            @Override
            public void onError(Request request, Exception e) {
            LogUtils.i("根据楼栋id分页查询房间信息失败");
                mViewRef.get().showError();
            }

            @Override
            public void onResponse(RoomMagementBases response) throws Exception {
                LogUtils.i("根据楼栋id分页查询房间信息成功" + GsonUtil.GsonString(response));
                mViewRef.get().setPageRoomData(response);
                if(response.getData().size()==0){
                    mViewRef.get().showEmpty();
                }else {
                    mViewRef.get().showSuccess();
                }
            }
        });
    }
}
