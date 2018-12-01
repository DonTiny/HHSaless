package com.hhsales.zzxinteyu.hhsales.client.model;

import com.example.lib_common.utils.okhttpUtils.ResultCallback;
import com.hhsales.zzxinteyu.hhsales.bean.Dictionary;
import com.hhsales.zzxinteyu.hhsales.bean.DictionaryData;
import com.hhsales.zzxinteyu.hhsales.bean.ProItemName;
import com.hhsales.zzxinteyu.hhsales.client.bean.ClientData;
import com.hhsales.zzxinteyu.hhsales.client.bean.PageClientInfo;
import com.hhsales.zzxinteyu.hhsales.client.bean.ProTeamByFKProject;

import java.util.Map;

/**
 * Created by Huairen on 2018/6/28.
 */

public interface IClientInfoModel {
    void getClientInfo(String client_id, ResultCallback<PageClientInfo<ClientData>> resultCallback);
    void getFindSysDictionaryItemByPk(String id, ResultCallback<Dictionary<DictionaryData>> resultCallback);
    void getfindProItemName(ResultCallback<ProItemName> resultCallback);

    void getfindProTeamByFKProjectId(String project_id, ResultCallback<ProTeamByFKProject> resultCallback);
    void updateClientInfo(Map<String, String> map, ResultCallback<String> resultCallback);
    void addClientInfo(Map<String, String> map, ResultCallback<String> resultCallback);

}
