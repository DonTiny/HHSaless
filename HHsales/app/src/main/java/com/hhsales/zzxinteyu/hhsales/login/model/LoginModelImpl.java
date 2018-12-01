package com.hhsales.zzxinteyu.hhsales.login.model;

import com.example.lib_common.utils.HttpUrl;
import com.example.lib_common.utils.okhttpUtils.OkHttpClientManager;
import com.example.lib_common.utils.okhttpUtils.ResultCallback;
import com.hhsales.zzxinteyu.hhsales.bean.ProItemName;
import com.hhsales.zzxinteyu.hhsales.client.bean.ProTeamByFKProject;

import java.util.Map;

/**
 * Created by Administrator on 2018/3/30.
 */

public class LoginModelImpl implements ILoginModel {

    @Override
    public void getPublicKey(Map<String, String> map, ResultCallback<String> callback) {
        OkHttpClientManager.getAsyn(HttpUrl.GENERATE_RSA_PUBLICK_KEY,null,callback);

    }

    @Override
    public void loginRequestBase64(Map<String, String> map, ResultCallback<String> callback) {
        OkHttpClientManager.postAsyn(HttpUrl.LOGIN_BASE,map,callback);
    }

    //一次性获取数据字典
    @Override
    public void getFindListSysDictionary(String string, ResultCallback<String> resultCallback) {
        OkHttpClientManager.postAsyn(HttpUrl.findListSysDictionary+"/"+string,null,resultCallback);
    }

    @Override
    public void getfindProItemName(ResultCallback<ProItemName> resultCallback) {
        OkHttpClientManager.postAsyn(HttpUrl.findProItemName, null, resultCallback);
    }

    @Override
    public void getfindProTeamByFKProjectId(String project_id, ResultCallback<ProTeamByFKProject> resultCallback) {

        OkHttpClientManager.postAsyn(HttpUrl.findProTeamByFKProjectId+"/"+project_id,null,resultCallback);
    }
}
