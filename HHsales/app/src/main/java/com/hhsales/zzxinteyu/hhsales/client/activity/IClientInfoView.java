package com.hhsales.zzxinteyu.hhsales.client.activity;

import com.hhsales.zzxinteyu.hhsales.client.bean.ClientData;
import com.hhsales.zzxinteyu.hhsales.client.bean.PageClientInfo;

import java.util.Map;

/**
 * Created by Huairen on 2018/6/28.
 */

public interface IClientInfoView {
    void setClient();
    void showClientInfo(PageClientInfo<ClientData> pageClientInfo);
    void showMarriage(String name);
    void showComprehensive_salary(String string);
    void showFk_age(String string);
    void showFk_use(String string);

    void showFk_follow_stage(String string);
    Map<String,String> getViewText();
    Map<String,String> getViewTextAdd();

    void updateClientInfo();

    void addYes();
    void addNo();
    void initDataNo(String type);
    void showToast(String text);
    void showError();
    void showLoading();
    void showSuccess();
    void showEmpty();

}
