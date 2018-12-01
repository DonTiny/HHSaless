package com.hhsales.zzxinteyu.hhsales.client.model;

import com.example.lib_common.utils.HttpUrl;
import com.example.lib_common.utils.okhttpUtils.OkHttpClientManager;
import com.example.lib_common.utils.okhttpUtils.ResultCallback;
import com.hhsales.zzxinteyu.hhsales.client.bean.Purchase;

/**
 * Created by Administrator on 2018/7/4.
 */

public class PurchaseModel implements IPurchaseModel {
    @Override
    public void findIntentionByClientId(String client_id, ResultCallback<Purchase> resultCallback) {
        OkHttpClientManager.postAsyn(HttpUrl.findIntentionByClientId+"/"+client_id,null,resultCallback);
    }
}
