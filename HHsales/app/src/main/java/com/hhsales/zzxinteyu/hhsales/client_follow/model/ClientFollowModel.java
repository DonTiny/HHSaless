package com.hhsales.zzxinteyu.hhsales.client_follow.model;

import com.example.lib_common.utils.HttpUrl;
import com.example.lib_common.utils.okhttpUtils.OkHttpClientManager;
import com.example.lib_common.utils.okhttpUtils.ResultCallback;
import com.hhsales.zzxinteyu.hhsales.client.bean.ClientData;
import com.hhsales.zzxinteyu.hhsales.client.bean.PageClientInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/10/30.
 */

public class ClientFollowModel implements IClientFollowModel {
     //分页查询用户跟进信息

    @Override
    public void findPageClientInfoState2(Map<String, String> map, ResultCallback<PageClientInfo<List<ClientData>>> resultCallback) {
        OkHttpClientManager.postAsyn(HttpUrl.FIND_PAGE_CLIENT_INFO_STATE2,map,resultCallback);

    }
}
