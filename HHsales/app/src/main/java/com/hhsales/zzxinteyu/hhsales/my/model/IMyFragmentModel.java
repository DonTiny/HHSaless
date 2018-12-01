package com.hhsales.zzxinteyu.hhsales.my.model;

import com.example.lib_common.utils.okhttpUtils.ResultCallback;
import com.hhsales.zzxinteyu.hhsales.bean.userinfo.UserInfo;

import java.util.Map;

import okhttp3.Callback;


/**
 * Created by Administrator on 2018/11/2.
 */

public interface IMyFragmentModel {
    void findMyUserInfo(Map<String, String> map, ResultCallback<UserInfo> resultCallback);
    void getVersion(Callback callback);
}
