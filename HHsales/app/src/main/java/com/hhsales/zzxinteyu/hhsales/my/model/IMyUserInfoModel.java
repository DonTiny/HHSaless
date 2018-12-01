package com.hhsales.zzxinteyu.hhsales.my.model;

import com.example.lib_common.utils.okhttpUtils.ResultCallback;
import com.hhsales.zzxinteyu.hhsales.bean.userinfo.UserInfo;

/**
 * Created by Administrator on 2018/11/6.
 */

public interface IMyUserInfoModel {
    void findMyUserInfo(ResultCallback<UserInfo> resultCallback);
}
