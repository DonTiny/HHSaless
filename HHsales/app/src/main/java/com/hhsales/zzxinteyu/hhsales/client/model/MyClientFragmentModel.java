package com.hhsales.zzxinteyu.hhsales.client.model;

import com.example.lib_common.utils.HttpUrl;
import com.example.lib_common.utils.okhttpUtils.OkHttpClientManager;
import com.example.lib_common.utils.okhttpUtils.ResultCallback;
import com.hhsales.zzxinteyu.hhsales.client.bean.ClientData;
import com.hhsales.zzxinteyu.hhsales.client.bean.PageClientInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by Huairen on 2018/6/20.
 */

public class MyClientFragmentModel implements IMyClientFragmentModel {
    @Override
    public void getPageClientInfo(Map<String, String> map, ResultCallback<PageClientInfo<List<ClientData>>> resultCallback) {
        OkHttpClientManager.postAsyn(HttpUrl.findPageClientInfo,map,resultCallback);
    }

    @Override
    public void findClientInfoState2(Map<String, String> map, ResultCallback<PageClientInfo<List<ClientData>>> resultCallback) {
        OkHttpClientManager.postAsyn((HttpUrl.findPageClientInfo), map, resultCallback);
    }
}
