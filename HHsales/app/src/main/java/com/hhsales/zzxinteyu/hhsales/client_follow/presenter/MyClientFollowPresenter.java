package com.hhsales.zzxinteyu.hhsales.client_follow.presenter;

import com.example.lib_common.mvp.presenter.BasePresenter;
import com.example.lib_common.utils.LogUtils;
import com.example.lib_common.utils.okhttpUtils.ResultCallback;
import com.hhsales.zzxinteyu.hhsales.client.bean.ClientData;
import com.hhsales.zzxinteyu.hhsales.client.bean.PageClientInfo;
import com.hhsales.zzxinteyu.hhsales.client_follow.fragment.IMyClientFollowFragment;
import com.hhsales.zzxinteyu.hhsales.client_follow.model.IMyClientFollowModel;
import com.hhsales.zzxinteyu.hhsales.client_follow.model.MyClientFollowModel;

import java.util.List;
import java.util.Map;

import okhttp3.Request;

/**
 * Created by Administrator on 2018/10/30.
 */

public class MyClientFollowPresenter extends BasePresenter<IMyClientFollowFragment> {
    IMyClientFollowModel iClientFollowModel = new MyClientFollowModel();
    public  void findPageClientInfoState2(final Map<String,String> map){


        iClientFollowModel.findClientInfoState2(map, new ResultCallback<PageClientInfo<List<ClientData>>>() {
            @Override
            public void onError(Request request, Exception e) {
                LogUtils.i("分页查询客户跟进失败"+e);
                mViewRef.get().showError();


            }

            @Override
            public void onResponse(PageClientInfo<List<ClientData>> response) throws Exception {
//                LogUtils.i("分页查询客户跟进成功"+response);
                mViewRef.get().showSuccess();
                mViewRef.get().showPageClientInfo(response);
            }
        });
    }

}
