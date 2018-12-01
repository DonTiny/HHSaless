package com.hhsales.zzxinteyu.hhsales.client_follow.model;

import com.example.lib_common.utils.okhttpUtils.ResultCallback;
import com.hhsales.zzxinteyu.hhsales.client.bean.ClientData;
import com.hhsales.zzxinteyu.hhsales.client.bean.PageClientInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/10/30.
 */

public class MyClientFollowModel extends ClientFollowModel implements IMyClientFollowModel {


    @Override
    public void findClientInfoState2(Map<String, String> map, ResultCallback<PageClientInfo<List<ClientData>>> resultCallback) {
        findPageClientInfoState2(map,resultCallback);

    }
}
