package com.hhsales.zzxinteyu.hhsales.client.activity;

import com.hhsales.zzxinteyu.hhsales.client.bean.Transaction;

/**
 * Created by Huairen on 2018/6/22.
 */

public interface IInteractionView {

    void showError();
    void showLoading();
    void showSuccess();
    void showEmpty();
    void getInteraction(String client_id);
    void setInteraction(Transaction transaction);
}
