package com.hhsales.zzxinteyu.hhsales.my.presenter;

import com.example.lib_common.mvp.presenter.BasePresenter;
import com.example.lib_common.utils.LogUtils;
import com.example.lib_common.utils.okhttpUtils.GsonUtil;
import com.example.lib_common.utils.okhttpUtils.ResultCallback;
import com.hhsales.zzxinteyu.hhsales.bean.userinfo.UserInfo;
import com.hhsales.zzxinteyu.hhsales.my.model.IMyUserInfoModel;
import com.hhsales.zzxinteyu.hhsales.my.model.MyUserInfoModel;
import com.hhsales.zzxinteyu.hhsales.my.ui.IMyUserInfoView;

import okhttp3.Request;

/**
 * Created by Administrator on 2018/11/6.
 */

public class MyUserInfoPresenter extends BasePresenter<IMyUserInfoView> {
    private IMyUserInfoModel iMyUserInfoModel = new MyUserInfoModel();

    public void findMyUserInfo(){
        iMyUserInfoModel.findMyUserInfo(new ResultCallback<UserInfo>() {
            @Override
            public void onError(Request request, Exception e) {
                LogUtils.i("查询用户信息失败");
                mViewRef.get().showError();
            }

            @Override
            public void onResponse(UserInfo response) throws Exception {
                LogUtils.i("查询用户信息成功"+ GsonUtil.GsonString(response));
                mViewRef.get().setViewData(response);
            }
        });
    }
}
