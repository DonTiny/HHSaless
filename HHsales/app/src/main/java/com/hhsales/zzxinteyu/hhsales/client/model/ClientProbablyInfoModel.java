package com.hhsales.zzxinteyu.hhsales.client.model;

import com.example.lib_common.utils.HttpUrl;
import com.example.lib_common.utils.LogUtils;
import com.example.lib_common.utils.okhttpUtils.OkHttpClientManager;
import com.example.lib_common.utils.okhttpUtils.ResultCallback;
import com.hhsales.zzxinteyu.hhsales.bean.Dictionary;
import com.hhsales.zzxinteyu.hhsales.bean.DictionaryData;
import com.hhsales.zzxinteyu.hhsales.client.bean.ClientData;
import com.hhsales.zzxinteyu.hhsales.client.bean.PageClientInfo;
import com.hhsales.zzxinteyu.hhsales.client.bean.Purchase;

import java.util.List;

/**
 * Created by Huairen on 2018/6/21.
 */

public class ClientProbablyInfoModel implements IClientProbablyInfoModel {
    //根据主键id查询客户信息
    @Override
    public void getClientInfo(String client_id,ResultCallback<PageClientInfo<ClientData>> resultCallback) {
        OkHttpClientManager.getAsyn(HttpUrl.findClientInfoByPk+"/"+client_id,null,resultCallback);
    }

    //根据主键id查询客户购房意向
    @Override
    public void findIntentionByClientId(String client_id, ResultCallback<Purchase> resultCallback) {
        OkHttpClientManager.postAsyn(HttpUrl.findIntentionByClientId+"/"+client_id,null,resultCallback);
    }

    //根据id查询数据字典
    @Override
    public void getFindSysDictionaryItemByPk(String id, ResultCallback<Dictionary<DictionaryData>> resultCallback) {
        OkHttpClientManager.getAsyn(HttpUrl.findSysDictionaryItemByPk+"/"+id,null,resultCallback);

    }
    //一次性获取数据字典
    @Override
    public void getFindListSysDictionary(String string, ResultCallback<String> resultCallback) {
        OkHttpClientManager.postAsyn(HttpUrl.findListSysDictionary+"/"+string,null,resultCallback);
    }
   // 获取交互明细数据
    @Override
    public void findClinetTrackByClientId(String client_id, ResultCallback<String> resultCallback) {
        OkHttpClientManager.postAsyn(HttpUrl.findClinetTrackByClientId+"/"+client_id,null ,resultCallback);
    }
}
