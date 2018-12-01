package com.hhsales.zzxinteyu.hhsales.my.fragment;

/**
 * Created by Administrator on 2018/11/2.
 */

public interface IMyFragmentView {
    void setUserName(String name);

    void setUserRole(String role);

    void showError();

    void showLoading();

    void showSuccess();

    void showEmpty();

    //获取当前版本号
    int getVersionCode();

    //开始更新
    void startpdateU(String url);

    void noUpdate();

    void getVersionError();

}
