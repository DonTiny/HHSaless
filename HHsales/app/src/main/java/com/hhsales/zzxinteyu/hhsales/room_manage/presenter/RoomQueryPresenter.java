package com.hhsales.zzxinteyu.hhsales.room_manage.presenter;

import com.example.lib_common.mvp.presenter.BasePresenter;
import com.example.lib_common.utils.GlideUtils;
import com.example.lib_common.utils.LogUtils;
import com.example.lib_common.utils.okhttpUtils.GsonUtil;
import com.example.lib_common.utils.okhttpUtils.ResultCallback;
import com.hhsales.zzxinteyu.hhsales.bean.ProItemName;
import com.hhsales.zzxinteyu.hhsales.bean.UserPermissions;
import com.hhsales.zzxinteyu.hhsales.room_manage.bean.ProjectBuiding;
import com.hhsales.zzxinteyu.hhsales.room_manage.bean.RoomQuery;
import com.hhsales.zzxinteyu.hhsales.room_manage.model.IRoomQueryModel;
import com.hhsales.zzxinteyu.hhsales.room_manage.model.RoomQueryModel;
import com.hhsales.zzxinteyu.hhsales.room_manage.ui.IRoomQueryView;

import java.util.HashMap;
import java.util.Map;

import okhttp3.Request;

/**
 * Created by Administrator on 2018/9/19.
 */

public class RoomQueryPresenter extends BasePresenter<IRoomQueryView>{

    private IRoomQueryModel iRoomQueryModel = new RoomQueryModel();
    private int project_index;
    private ProItemName proItemName;
    public RoomQueryPresenter() {


    }
    public void getProItemName(){
        iRoomQueryModel.findProItemNameByNo501(null, new ResultCallback<ProItemName>() {
            @Override
            public void onError(Request request, Exception e) {
                LogUtils.i("获取项目名称失败"+e);
                mViewRef.get().requestFailed();
            }

            @Override
            public void onResponse(ProItemName response) throws Exception {
                LogUtils.i("获取项目名称成功"+response);
                proItemName = response;
                project_index=0;
                findProBuildingByFKProjectId(proItemName.getData().get(project_index).getProject_id());

            }
        });

    }

//根据项目id查询楼栋
  private void  findProBuildingByFKProjectId(final String project_id){
         iRoomQueryModel.findProBuildingByFKProjectId(project_id, new ResultCallback<ProjectBuiding>() {
             @Override
             public void onError(Request request, Exception e) {
                 LogUtils.i("根据项目id查询楼栋信息失败");
                 mViewRef.get().requestFailed();

             }
             @Override
             public void onResponse(ProjectBuiding response) throws Exception {
                 LogUtils.i("根据项目id查询楼栋信息成功");
                 if(response.getData().size()>0){
                     mViewRef.get().firstInitBuilding(proItemName.getData().get(project_index).getItem_name(), response.getData().get(0).getName(), response.getData().get(0).getBuilding_id());
                     project_index=-1;
                     LogUtils.i("楼栋大于1");
                 }else if(project_index!=-1){
                     project_index++;
                     findProBuildingByFKProjectId(proItemName.getData().get(project_index).getProject_id());
                     LogUtils.i("楼栋小于1");

                 }

             }
         });

  }

    public void getRoomByBuildingId(String building_id){
        iRoomQueryModel.findRoomByBuildingId(building_id, new ResultCallback<RoomQuery>() {
            @Override
            public void onError(Request request, Exception e) {
                LogUtils.i("按楼栋id查询房间失败"+e);
                mViewRef.get().requestFailed();

            }

            @Override
            public void onResponse(RoomQuery response) throws Exception {
                LogUtils.i("按楼栋id查询房间成功"+ GsonUtil.GsonString(response));
                 mViewRef.get().setRoomQueryData(response);
            }
        });
    }


    /**
     * 权限检查
     */

    //检查楼栋管理权限
    public void checkBuildingPermissions(Map<String,String> map){
        iRoomQueryModel.checkBuildingPermissions(map, new ResultCallback<UserPermissions>() {
            @Override
            public void onError(Request request, Exception e) {
                LogUtils.i("查询权限信息失败"+e);
                mViewRef.get().requestFailed();
            }

            @Override
            public void onResponse(UserPermissions response) throws Exception {
                LogUtils.i("查询权限信息成功"+ GsonUtil.GsonString(response));
                String permissions = response.getRoleValue();
                if (Character.valueOf(permissions.charAt(3)).equals("1")){
                    LogUtils.i("拥有查询楼栋权限");


                }else {
                    LogUtils.i("未拥有查询楼栋权限");
                    mViewRef.get().permissionsNo();
                }

            }
        });

    }
}
