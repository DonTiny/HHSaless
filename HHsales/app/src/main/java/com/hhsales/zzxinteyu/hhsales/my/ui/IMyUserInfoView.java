package com.hhsales.zzxinteyu.hhsales.my.ui;

import com.hhsales.zzxinteyu.hhsales.bean.userinfo.UserInfo;

/**
 * Created by Administrator on 2018/11/6.
 */

public interface IMyUserInfoView {
    void setViewData(UserInfo userInfo);
    void showError();
    void showLoading();
    void showSuccess();
    void showEmpty();
}
