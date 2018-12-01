package com.hhsales.zzxinteyu.hhsales.my.presenter;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import com.example.lib_common.mvp.presenter.BasePresenter;
import com.example.lib_common.utils.LogUtils;
import com.example.lib_common.utils.okhttpUtils.GsonUtil;
import com.example.lib_common.utils.okhttpUtils.OkHttpClientManager;
import com.example.lib_common.utils.okhttpUtils.ResultCallback;
import com.hhsales.zzxinteyu.hhsales.bean.userinfo.UserInfo;
import com.hhsales.zzxinteyu.hhsales.my.bean.UpdateInfo;
import com.hhsales.zzxinteyu.hhsales.my.fragment.IMyFragmentView;
import com.hhsales.zzxinteyu.hhsales.my.model.IMyFragmentModel;
import com.hhsales.zzxinteyu.hhsales.my.model.MyFragmentModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2018/11/2.
 */

public class MyFragmentPresenter extends BasePresenter<IMyFragmentView> {
    IMyFragmentModel iMyFragmentModel = new MyFragmentModel();

    public void findMyUserInfo() {
        iMyFragmentModel.findMyUserInfo(null, new ResultCallback<UserInfo>() {
            @Override
            public void onError(Request request, Exception e) {
                LogUtils.i("查询我的信息失败" + e);
                mViewRef.get().showError();
            }

            @Override
            public void onResponse(UserInfo response) throws Exception {
               // LogUtils.i("查询我的信息成功" + GsonUtil.GsonString(response));
                if (response == null) {
                    LogUtils.i("网络异常，请刷新");
                } else {
                    mViewRef.get().setUserName(response.getData().get(0).getListStaff().get(0).getName());
                    mViewRef.get().setUserRole(response.getData().get(0).getListRole().get(0).getName());
                }

            }
        });
    }


    public void getVersion() {
        iMyFragmentModel.getVersion(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
              mViewRef.get().getVersionError();

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseBody = response.body().string();
                StringBuffer sb = new StringBuffer();
                BufferedReader reader = null;
                UpdateInfo updateInfo = new UpdateInfo();
                Log.d("版本", "onResponse: "+responseBody);
                reader = new BufferedReader(new StringReader(responseBody));
                updateInfo.setVersion(reader.readLine());//把版本信息读出来
                updateInfo.setDescription(reader.readLine());
                updateInfo.setUrl(reader.readLine());
                int new_version = Integer.parseInt(updateInfo.getVersion());
                LogUtils.i("版本"+ "onResponse: "+updateInfo.getVersion());
                LogUtils.i("版本描述"+ "onResponse: "+updateInfo.getDescription());
                LogUtils.i("更新链接"+ "onResponse: "+updateInfo.getUrl());
                int now_version = mViewRef.get().getVersionCode();

                if(new_version>now_version){
                LogUtils.i("开始更新");
                mViewRef.get().startpdateU(updateInfo.getUrl());
                }else{
                    LogUtils.i("已经是最新版本了");
                    mViewRef.get().noUpdate();

                }
            }
        });
    }
}
