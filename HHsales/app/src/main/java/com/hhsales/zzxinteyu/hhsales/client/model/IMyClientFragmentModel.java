package com.hhsales.zzxinteyu.hhsales.client.model;

import com.example.lib_common.utils.okhttpUtils.ResultCallback;
import com.hhsales.zzxinteyu.hhsales.client.bean.ClientData;
import com.hhsales.zzxinteyu.hhsales.client.bean.PageClientInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by Huairen on 2018/6/20.
 */

public interface IMyClientFragmentModel {
    void getPageClientInfo(Map<String, String> map, ResultCallback<PageClientInfo<List<ClientData>>> resultCallback);
    //根据条件查询用户
    void findClientInfoState2(Map<String, String> map, ResultCallback<PageClientInfo<List<ClientData>>> resultCallback);
}
