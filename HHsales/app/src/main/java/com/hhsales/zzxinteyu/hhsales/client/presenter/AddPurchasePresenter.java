package com.hhsales.zzxinteyu.hhsales.client.presenter;

import com.example.lib_common.mvp.presenter.BasePresenter;
import com.example.lib_common.utils.LogUtils;
import com.example.lib_common.utils.okhttpUtils.ResultCallback;
import com.hhsales.zzxinteyu.hhsales.client.activity.IAddPurchaseView;
import com.hhsales.zzxinteyu.hhsales.client.model.AddPurchaseModel;
import com.hhsales.zzxinteyu.hhsales.client.model.IAddPurchaseModel;

import okhttp3.Request;

/**
 * Created by Administrator on 2018/7/4.
 */

public class AddPurchasePresenter extends BasePresenter<IAddPurchaseView> {
    private IAddPurchaseModel iAddPurchaseModel = new AddPurchaseModel();
    //新增购房意向
    public  void addIntention(){
        LogUtils.i("打印新增参数"+mViewRef.get().getTextView());
        iAddPurchaseModel.addIntention(mViewRef.get().getTextView(), new ResultCallback<String>() {
            @Override
            public void onError(Request request, Exception e) {
                LogUtils.i("新增失败"+e);
            }

            @Override
            public void onResponse(String response) throws Exception {
                LogUtils.i("新增成功"+response);

            }
        });
    }
}
