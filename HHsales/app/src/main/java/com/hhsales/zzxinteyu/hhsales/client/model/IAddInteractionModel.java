package com.hhsales.zzxinteyu.hhsales.client.model;

import com.example.lib_common.utils.okhttpUtils.ResultCallback;

import java.util.Map;

/**
 * Created by Huairen on 2018/6/25.
 */

public interface IAddInteractionModel {
    void addClinetTrack(Map<String, String> map, ResultCallback<String> resultCallback);

}
