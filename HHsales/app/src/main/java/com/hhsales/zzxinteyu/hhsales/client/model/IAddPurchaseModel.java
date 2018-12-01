package com.hhsales.zzxinteyu.hhsales.client.model;

import com.example.lib_common.utils.okhttpUtils.ResultCallback;

import java.util.Map;

/**
 * Created by Administrator on 2018/7/4.
 */

public interface IAddPurchaseModel {
    void addIntention(Map<String, String> map, ResultCallback<String> resultCallback);

}
