package com.hhsales.zzxinteyu.hhsales.client_follow.model;

import com.example.lib_common.utils.okhttpUtils.ResultCallback;
import com.hhsales.zzxinteyu.hhsales.bean.ProItemName;
import com.hhsales.zzxinteyu.hhsales.bean.UserPermissions;

import java.util.Map;

/**
 * Created by Administrator on 2018/11/15.
 */

public interface IFollowModel {
    void findProItemName(Map<String,String> map,ResultCallback<ProItemName> resultCallback);
    void checkPermissions345(Map<String, String> map, ResultCallback<UserPermissions> resultCallback);
    void checkPermissions2(Map<String, String> map, ResultCallback<UserPermissions> resultCallback);

}
