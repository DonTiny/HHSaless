package com.hhsales.zzxinteyu.hhsales.client_follow.presenter;

import com.example.lib_common.mvp.presenter.BasePresenter;
import com.example.lib_common.utils.LogUtils;
import com.example.lib_common.utils.okhttpUtils.GsonUtil;
import com.example.lib_common.utils.okhttpUtils.ResultCallback;
import com.hhsales.zzxinteyu.hhsales.bean.ProItemName;
import com.hhsales.zzxinteyu.hhsales.bean.UserPermissions;
import com.hhsales.zzxinteyu.hhsales.client_follow.model.FollowModel;
import com.hhsales.zzxinteyu.hhsales.client_follow.model.IFollowModel;
import com.hhsales.zzxinteyu.hhsales.client_follow.ui.IFollowView;

import java.util.HashMap;
import java.util.Map;

import okhttp3.Request;

/**
 * Created by Administrator on 2018/11/15.
 */

public class FollowPresenter extends BasePresenter<IFollowView> {
    private IFollowModel iFollowModel = new FollowModel();

    public void findProItemName(){
        Map<String, String> map = new HashMap<>();
        map.put("canshu", "1");
        iFollowModel.findProItemName(map,new ResultCallback<ProItemName>() {
            @Override
            public void onError(Request request, Exception e) {
                LogUtils.i("查询当前用户所属项目失败"+e);

            }

            @Override
            public void onResponse(ProItemName response) throws Exception {
//                LogUtils.i("查询当前用户所属项目成功");
                mViewRef.get().setPageData(response);
            }
        });
    }
    public void checkPermissions(Map<String,String> map){
        iFollowModel.checkPermissions2(map, new ResultCallback<UserPermissions>() {
            @Override
            public void onError(Request request, Exception e) {
                LogUtils.i("查询权限信息失败"+e);
            }

            @Override
            public void onResponse(UserPermissions response) throws Exception {
                LogUtils.i("查询权限信息成功"+ GsonUtil.GsonString(response));
                mViewRef.get().setPermissions(response);

            }
        });

    }
}
