package com.hhsales.zzxinteyu.hhsales.login.model;

import com.example.lib_common.utils.okhttpUtils.ResultCallback;
import com.hhsales.zzxinteyu.hhsales.bean.ProItemName;
import com.hhsales.zzxinteyu.hhsales.client.bean.ProTeamByFKProject;

import java.util.Map;

/**
 * Created by Administrator on 2018/3/30.
 */

public interface ILoginModel {
    //该方法实现数据现在
    void getPublicKey(Map<String, String> map, ResultCallback<String> callback);

    void loginRequestBase64(Map<String, String> map, ResultCallback<String> callback);

    //一次性获取数据字典
    void getFindListSysDictionary(String string, ResultCallback<String> resultCallback);

    void getfindProItemName(ResultCallback<ProItemName> resultCallback);

    void getfindProTeamByFKProjectId(String project_id, ResultCallback<ProTeamByFKProject> resultCallback);
}
