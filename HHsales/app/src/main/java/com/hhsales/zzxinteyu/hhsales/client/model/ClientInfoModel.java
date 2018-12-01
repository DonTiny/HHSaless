package com.hhsales.zzxinteyu.hhsales.client.model;

import com.example.lib_common.utils.HttpUrl;
import com.example.lib_common.utils.LogUtils;
import com.example.lib_common.utils.okhttpUtils.OkHttpClientManager;
import com.example.lib_common.utils.okhttpUtils.ResultCallback;
import com.hhsales.zzxinteyu.hhsales.bean.Dictionary;
import com.hhsales.zzxinteyu.hhsales.bean.DictionaryData;
import com.hhsales.zzxinteyu.hhsales.bean.ProItemName;
import com.hhsales.zzxinteyu.hhsales.client.activity.IClientInfoView;
import com.hhsales.zzxinteyu.hhsales.client.bean.ClientData;
import com.hhsales.zzxinteyu.hhsales.client.bean.PageClientInfo;
import com.hhsales.zzxinteyu.hhsales.client.bean.ProTeamByFKProject;

import java.util.Map;

/**
 * Created by Huairen on 2018/6/28.
 */

public class ClientInfoModel implements IClientInfoModel {
    //根据主键id查询客户信息
    @Override
    public void getClientInfo(String client_id,ResultCallback<PageClientInfo<ClientData>> resultCallback) {
        OkHttpClientManager.getAsyn(HttpUrl.findClientInfoByPk+"/"+client_id,null,resultCallback);
    }

    //id查询数据字典
    @Override
    public void getFindSysDictionaryItemByPk(String id, ResultCallback<Dictionary<DictionaryData>> resultCallback) {
        OkHttpClientManager.getAsyn(HttpUrl.findSysDictionaryItemByPk+"/"+id,null,resultCallback);

    }

    @Override
    public void getfindProItemName(ResultCallback<ProItemName> resultCallback) {
        OkHttpClientManager.postAsyn(HttpUrl.findProItemName, null, resultCallback);
    }

    @Override
    public void getfindProTeamByFKProjectId(String project_id, ResultCallback<ProTeamByFKProject> resultCallback) {

        OkHttpClientManager.postAsyn(HttpUrl.findProTeamByFKProjectId+"/"+project_id,null,resultCallback);
    }

    //修改客户信息
    @Override
    public void updateClientInfo(Map<String, String> map, ResultCallback<String> resultCallback) {
        OkHttpClientManager.postAsyn(HttpUrl.updateClientInfo, map, resultCallback);
    }

    @Override
    public void addClientInfo(Map<String, String> map, ResultCallback<String> resultCallback) {
        OkHttpClientManager.postAsyn(HttpUrl.addClientInfo, map, resultCallback);
    }
}
