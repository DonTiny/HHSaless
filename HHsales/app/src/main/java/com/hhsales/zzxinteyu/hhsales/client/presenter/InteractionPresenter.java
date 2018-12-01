package com.hhsales.zzxinteyu.hhsales.client.presenter;

import com.example.lib_common.mvp.presenter.BasePresenter;
import com.example.lib_common.utils.okhttpUtils.GsonUtil;
import com.example.lib_common.utils.okhttpUtils.ResultCallback;
import com.hhsales.zzxinteyu.hhsales.client.activity.IInteractionView;
import com.hhsales.zzxinteyu.hhsales.client.bean.Transaction;
import com.hhsales.zzxinteyu.hhsales.client.model.ClientProbablyInfoModel;
import com.hhsales.zzxinteyu.hhsales.client.model.IClientProbablyInfoModel;

import okhttp3.Request;

/**
 * Created by Huairen on 2018/6/22.
 */

public class InteractionPresenter extends BasePresenter<IInteractionView> {
    private IClientProbablyInfoModel iClientProbablyInfoModel = new ClientProbablyInfoModel();

    //获取交互明细数据
    public void findClinetTrackByClientId(String client_id){
        iClientProbablyInfoModel.findClinetTrackByClientId(client_id, new ResultCallback<String>() {
            @Override
            public void onError(Request request, Exception e) {
                mViewRef.get().showError();
            }

            @Override
            public void onResponse(String response) {
                Transaction transaction= GsonUtil.GsonToBean(response,Transaction.class);
                mViewRef.get().setInteraction(transaction);
                mViewRef.get().showSuccess();

            }
        });
    }
}
