package com.hhsales.zzxinteyu.hhsales.client.model;

import com.example.lib_common.utils.HttpUrl;
import com.example.lib_common.utils.okhttpUtils.OkHttpClientManager;
import com.example.lib_common.utils.okhttpUtils.ResultCallback;

import java.util.Map;

/**
 * Created by Administrator on 2018/7/4.
 */

public class AddPurchaseModel implements IAddPurchaseModel {
    @Override
    public void addIntention(Map<String, String> map, ResultCallback<String> resultCallback) {
        OkHttpClientManager.postAsyn(HttpUrl.addIntention,map,resultCallback);
    }
}
