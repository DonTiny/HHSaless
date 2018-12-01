package com.hhsales.zzxinteyu.hhsales.client.model;

import com.example.lib_common.utils.okhttpUtils.ResultCallback;
import com.hhsales.zzxinteyu.hhsales.bean.Dictionary;
import com.hhsales.zzxinteyu.hhsales.bean.DictionaryData;
import com.hhsales.zzxinteyu.hhsales.client.bean.ClientData;
import com.hhsales.zzxinteyu.hhsales.client.bean.PageClientInfo;
import com.hhsales.zzxinteyu.hhsales.client.bean.Purchase;

/**
 * Created by Huairen on 2018/6/21.
 */

public interface IClientProbablyInfoModel {
    void getClientInfo(String client_id, ResultCallback<PageClientInfo<ClientData>> resultCallback);
    void findIntentionByClientId(String client_id, ResultCallback<Purchase> resultCallback);
    void getFindSysDictionaryItemByPk(String id, ResultCallback<Dictionary<DictionaryData>> resultCallback);
    //一次性获取数据字典
    void getFindListSysDictionary(String string, ResultCallback<String> resultCallback);
    void findClinetTrackByClientId(String client_id, ResultCallback<String> resultCallback);

}
