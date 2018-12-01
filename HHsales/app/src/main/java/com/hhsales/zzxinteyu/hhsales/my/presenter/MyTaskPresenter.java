package com.hhsales.zzxinteyu.hhsales.my.presenter;

import com.example.lib_common.mvp.presenter.BasePresenter;
import com.example.lib_common.utils.LogUtils;
import com.example.lib_common.utils.okhttpUtils.GsonUtil;
import com.example.lib_common.utils.okhttpUtils.ResultCallback;
import com.hhsales.zzxinteyu.hhsales.my.bean.MyTaskBean;
import com.hhsales.zzxinteyu.hhsales.my.model.IMyTaskModel;
import com.hhsales.zzxinteyu.hhsales.my.model.MyTaskModel;
import com.hhsales.zzxinteyu.hhsales.my.ui.IMyTaskView;

import java.util.List;
import java.util.Map;

import okhttp3.Request;

/**
 * Created by Administrator on 2018/11/16.
 */

public class MyTaskPresenter extends BasePresenter<IMyTaskView> {
    private IMyTaskModel iMyTaskModel = new MyTaskModel();


    public void findPageClinetTrack(final Map<String, String> map) {
        iMyTaskModel.findPageClinetTrack(map, new ResultCallback<MyTaskBean>() {
            @Override
            public void onError(Request request, Exception e) {
                LogUtils.i("获取当天任务请求失败"+e);
                mViewRef.get().showError();
            }

            @Override
            public void onResponse(MyTaskBean response) throws Exception {
                LogUtils.i("获取当天任务请求成功"+ GsonUtil.GsonString(response));
                mViewRef.get().setMyTask(response);

            }
        });
    }

}
