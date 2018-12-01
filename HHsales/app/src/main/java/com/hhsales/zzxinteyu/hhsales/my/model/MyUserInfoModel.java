package com.hhsales.zzxinteyu.hhsales.my.model;

import com.example.lib_common.utils.HttpUrl;
import com.example.lib_common.utils.okhttpUtils.OkHttpClientManager;
import com.example.lib_common.utils.okhttpUtils.ResultCallback;
import com.hhsales.zzxinteyu.hhsales.bean.userinfo.UserInfo;

/**
 * Created by Administrator on 2018/11/6.
 */

public class MyUserInfoModel  implements IMyUserInfoModel{
    @Override
    public void findMyUserInfo(ResultCallback<UserInfo> resultCallback) {
        OkHttpClientManager.getAsyn(HttpUrl.FIND_MY_USER_INFO,null,resultCallback);
    }
}
