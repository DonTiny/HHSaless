package com.hhsales.zzxinteyu.hhsales.client.model;

import com.example.lib_common.utils.HttpUrl;
import com.example.lib_common.utils.okhttpUtils.OkHttpClientManager;
import com.example.lib_common.utils.okhttpUtils.ResultCallback;

import java.util.Map;

/**
 * Created by Huairen on 2018/6/25.
 */

public class AddInteractionModel implements IAddInteractionModel {
    @Override
    public void addClinetTrack(Map<String, String> map, ResultCallback<String> resultCallback) {
        OkHttpClientManager.postAsyn(HttpUrl.addClinetTrack,map,resultCallback);
    }
}
