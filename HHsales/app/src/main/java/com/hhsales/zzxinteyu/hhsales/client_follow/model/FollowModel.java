package com.hhsales.zzxinteyu.hhsales.client_follow.model;

import com.example.lib_common.utils.HttpUrl;
import com.example.lib_common.utils.okhttpUtils.OkHttpClientManager;
import com.example.lib_common.utils.okhttpUtils.ResultCallback;
import com.hhsales.zzxinteyu.hhsales.bean.ProItemName;
import com.hhsales.zzxinteyu.hhsales.bean.UserPermissions;

import java.util.Map;

/**
 * Created by Administrator on 2018/11/15.
 */

public class FollowModel implements IFollowModel {
    @Override
    public void findProItemName(Map<String,String> map,ResultCallback<ProItemName> resultCallback) {
        OkHttpClientManager.getAsyn(HttpUrl.FIND_PRO_ITEM_NAME,map,resultCallback);
    }

    @Override
    public void checkPermissions345(Map<String, String> map, ResultCallback<UserPermissions> resultCallback) {
        OkHttpClientManager.postAsyn(HttpUrl.findPageClientInfo, map, resultCallback);
    }

    @Override
    public void checkPermissions2(Map<String, String> map, ResultCallback<UserPermissions> resultCallback) {
        OkHttpClientManager.postAsyn(HttpUrl.FIND_PAGE_CLIENT_INFO_STATE2,map,resultCallback);
    }
}
