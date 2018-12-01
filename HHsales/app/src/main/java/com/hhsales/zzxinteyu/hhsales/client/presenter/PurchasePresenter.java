package com.hhsales.zzxinteyu.hhsales.client.presenter;

import com.example.lib_common.mvp.presenter.BasePresenter;
import com.example.lib_common.utils.LogUtils;
import com.example.lib_common.utils.okhttpUtils.GsonUtil;
import com.example.lib_common.utils.okhttpUtils.ResultCallback;
import com.hhsales.zzxinteyu.hhsales.client.activity.IPurchaseView;
import com.hhsales.zzxinteyu.hhsales.client.bean.Purchase;
import com.hhsales.zzxinteyu.hhsales.client.model.IPurchaseModel;
import com.hhsales.zzxinteyu.hhsales.client.model.PurchaseModel;

import okhttp3.Request;

/**
 * Created by Administrator on 2018/7/4.
 */

public class PurchasePresenter extends BasePresenter<IPurchaseView> {
    private IPurchaseModel iPurchaseModel = new PurchaseModel();

    //客户id查询意向房间
    public void findIntentionByClientId(String client_id){
        iPurchaseModel.findIntentionByClientId(client_id, new ResultCallback<Purchase>() {
            @Override
            public void onError(Request request, Exception e) {
                LogUtils.i("查询购房意向失败"+e);
                mViewRef.get().showError();
            }

            @Override
            public void onResponse(Purchase response) throws Exception {
                LogUtils.i("查询购房意向成功"+ GsonUtil.GsonString(response));
                mViewRef.get().setPurchaseData(response);
            }
        });
    }
}
