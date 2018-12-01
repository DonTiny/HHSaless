package com.hhsales.zzxinteyu.hhsales.my.model;

import com.example.lib_common.utils.HttpUrl;
import com.example.lib_common.utils.okhttpUtils.OkHttpClientManager;
import com.example.lib_common.utils.okhttpUtils.ResultCallback;
import com.hhsales.zzxinteyu.hhsales.bean.userinfo.UserInfo;

import java.util.Map;

import okhttp3.Callback;


/**
 * Created by Administrator on 2018/11/2.
 */

public class MyFragmentModel implements IMyFragmentModel {
    @Override
    public void findMyUserInfo(Map<String, String> map, ResultCallback<UserInfo> resultCallback) {
        OkHttpClientManager.getAsyn(HttpUrl.FIND_MY_USER_INFO, null, resultCallback);
    }
    //获取版本信息
    @Override
    public void getVersion(Callback callback) {
        OkHttpClientManager.download(HttpUrl.GET_VERSION, callback);
    }
}
