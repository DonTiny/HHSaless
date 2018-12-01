package com.hhsales.zzxinteyu.hhsales.client.model;

import com.example.lib_common.utils.okhttpUtils.ResultCallback;
import com.hhsales.zzxinteyu.hhsales.client.bean.Purchase;

/**
 * Created by Administrator on 2018/7/4.
 */

public interface IPurchaseModel {
    void findIntentionByClientId(String client_id, ResultCallback<Purchase> resultCallback);

}
