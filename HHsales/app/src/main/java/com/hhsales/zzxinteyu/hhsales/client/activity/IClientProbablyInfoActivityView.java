package com.hhsales.zzxinteyu.hhsales.client.activity;

import com.hhsales.zzxinteyu.hhsales.client.bean.ClientData;
import com.hhsales.zzxinteyu.hhsales.client.bean.PageClientInfo;
import com.hhsales.zzxinteyu.hhsales.client.bean.Purchase;
import com.hhsales.zzxinteyu.hhsales.client.bean.Transaction;

/**
 * Created by Huairen on 2018/6/21.
 */

public interface IClientProbablyInfoActivityView  {
    void getClientInfo(String client_id);
    void setClientInfo(PageClientInfo<ClientData> clientInfo);
    void getPurchase(String client_id);
    void setPurchase(Purchase purchase);
    void show_mTv_purchase_use(String text);
    void show_mTv_purchase_room_type(String text);
    void showError();
    void showLoading();
    void showSuccess();
    void showEmpty();
    void getInteraction(String client_id);
    void setInteraction(Transaction transaction);
}
