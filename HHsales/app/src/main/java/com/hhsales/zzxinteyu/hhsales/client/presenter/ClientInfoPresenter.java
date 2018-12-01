package com.hhsales.zzxinteyu.hhsales.client.presenter;

import com.example.lib_common.mvp.presenter.BasePresenter;
import com.example.lib_common.utils.LogUtils;
import com.example.lib_common.utils.okhttpUtils.GsonUtil;
import com.example.lib_common.utils.okhttpUtils.ResultCallback;
import com.hhsales.zzxinteyu.hhsales.bean.Dictionary;
import com.hhsales.zzxinteyu.hhsales.bean.DictionaryData;
import com.hhsales.zzxinteyu.hhsales.bean.ProItemName;
import com.hhsales.zzxinteyu.hhsales.client.activity.IClientInfoView;
import com.hhsales.zzxinteyu.hhsales.client.bean.ClientData;
import com.hhsales.zzxinteyu.hhsales.client.bean.PageClientInfo;
import com.hhsales.zzxinteyu.hhsales.client.bean.ProTeamByFKProject;
import com.hhsales.zzxinteyu.hhsales.client.model.ClientInfoModel;
import com.hhsales.zzxinteyu.hhsales.client.model.IClientInfoModel;
import com.hhsales.zzxinteyu.hhsales.utlis.ClientInfoDataDictionary;

import java.util.Map;

import okhttp3.Request;

/**
 * Created by Huairen on 2018/6/28.
 */

public class ClientInfoPresenter extends BasePresenter<IClientInfoView>{
    private IClientInfoModel iClientInfoModel = new ClientInfoModel();
    private int search_progress=0;

    //根据id查询用户信息
    public void setClientInfo(String client_id) {
        iClientInfoModel.getClientInfo(client_id, new ResultCallback<PageClientInfo<ClientData>>() {
            @Override
            public void onError(Request request, Exception e) {
                LogUtils.i("根据id查询用户信息失败");
                mViewRef.get().showError();
            }

            @Override
            public void onResponse(PageClientInfo<ClientData> response){
                LogUtils.i("根据id查询用户信息成功" + response);
                mViewRef.get().showClientInfo(response);
                mViewRef.get().showSuccess();

            }
        });

    }//根据id查询数据字典
    public void findSysDictionaryItemByPk(String id) {
        iClientInfoModel.getFindSysDictionaryItemByPk(id, new ResultCallback<Dictionary<DictionaryData>>() {
            @Override
            public void onError(Request request, Exception e) {
                LogUtils.i("id查询数据字典失败" + e);
                mViewRef.get().showError();
            }

            @Override
            public void onResponse( Dictionary<DictionaryData> response) {

                if(response.getData().getFk_dictionary_id().equals("5"))
                    mViewRef.get().showMarriage(response.getData().getName());
                if(response.getData().getFk_dictionary_id().equals("6"))
                    mViewRef.get().showComprehensive_salary(response.getData().getName());
                if(response.getData().getFk_dictionary_id().equals("14"))
                    mViewRef.get().showFk_age(response.getData().getName());
                if(response.getData().getFk_dictionary_id().equals("15"))
                    mViewRef.get().showFk_use(response.getData().getName());
                if(response.getData().getFk_dictionary_id().equals("4"))
                    mViewRef.get().showFk_follow_stage(response.getData().getName());

            }
        });
    }

    public void updateClientInfo(){
        Map<String, String> map = mViewRef.get().getViewTextAdd();
        if(map!=null)
            iClientInfoModel.updateClientInfo(map, new ResultCallback<String>() {
                @Override
                public void onError(Request request, Exception e) {
                    LogUtils.i("更新用户失败"+e);
                    mViewRef.get().showToast("更新失败，请检查网络");
                }

                @Override
                public void onResponse(String response) {
                    LogUtils.i("更新用户成功"+response);
                    mViewRef.get().showToast("更新成功");

                }
            });

    }

    //新增用户
    public   void  addClientInfo(){
        Map<String, String> map = mViewRef.get().getViewTextAdd();
        if(map!=null)
            iClientInfoModel.addClientInfo(map, new ResultCallback<String>() {
                @Override
                public void onError(Request request, Exception e) {
                    LogUtils.i("新增用户失败");
                    mViewRef.get().addNo();
                }

                @Override
                public void onResponse(String response) throws Exception {
                    LogUtils.i("新增用户成功"+response);
                    mViewRef.get().addYes();
                }
            });

    }
}
