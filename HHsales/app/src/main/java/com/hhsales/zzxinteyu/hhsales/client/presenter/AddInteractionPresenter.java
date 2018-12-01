package com.hhsales.zzxinteyu.hhsales.client.presenter;

import com.example.lib_common.base.BaseActivity;
import com.example.lib_common.mvp.presenter.BasePresenter;
import com.example.lib_common.utils.LogUtils;
import com.example.lib_common.utils.okhttpUtils.ResultCallback;
import com.hhsales.zzxinteyu.hhsales.client.activity.IAddInteractionView;
import com.hhsales.zzxinteyu.hhsales.client.model.AddInteractionModel;
import com.hhsales.zzxinteyu.hhsales.client.model.IAddInteractionModel;

import okhttp3.Request;

/**
 * Created by Huairen on 2018/6/25.
 */

public class AddInteractionPresenter extends BasePresenter<IAddInteractionView> {
    private IAddInteractionModel iAddInteractionModel = new AddInteractionModel();

    //保存交互信息
    public void addClinetTrack(){
        if(mViewRef.get().getViewText()!=null)
            iAddInteractionModel.addClinetTrack(mViewRef.get().getViewText(), new ResultCallback<String>() {
                @Override
                public void onError(Request request, Exception e) {
                    LogUtils.i("保存用户交互信息失败"+e);
                    mViewRef.get().addClinetTrackResults(0);

                }

                @Override
                public void onResponse(String response) {
                    LogUtils.i("保存用户交互信息成功"+response);
                    mViewRef.get().addClinetTrackResults(1);

                }
            });
    }
}
