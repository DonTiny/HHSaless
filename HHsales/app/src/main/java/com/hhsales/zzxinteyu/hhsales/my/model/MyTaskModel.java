package com.hhsales.zzxinteyu.hhsales.my.model;

import com.example.lib_common.utils.HttpUrl;
import com.example.lib_common.utils.okhttpUtils.OkHttpClientManager;
import com.example.lib_common.utils.okhttpUtils.ResultCallback;
import com.hhsales.zzxinteyu.hhsales.my.bean.MyTaskBean;

import java.util.Map;

/**
 * Created by Administrator on 2018/11/16.
 */

public class MyTaskModel implements IMyTaskModel {

    @Override
    public void findPageClinetTrack(Map<String, String> map,ResultCallback<MyTaskBean> resultCallback) {
        OkHttpClientManager.postAsyn(HttpUrl.FIND_PAGE_CLIENT_TRACK,map,resultCallback);
    }
}
