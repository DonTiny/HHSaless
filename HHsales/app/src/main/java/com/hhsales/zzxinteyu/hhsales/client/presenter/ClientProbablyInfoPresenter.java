package com.hhsales.zzxinteyu.hhsales.client.presenter;

import com.example.lib_common.base.BaseActivity;
import com.example.lib_common.mvp.presenter.BasePresenter;
import com.example.lib_common.utils.LogUtils;
import com.example.lib_common.utils.okhttpUtils.GsonUtil;
import com.example.lib_common.utils.okhttpUtils.ResultCallback;
import com.hhsales.zzxinteyu.hhsales.bean.Dictionary;
import com.hhsales.zzxinteyu.hhsales.bean.DictionaryData;
import com.hhsales.zzxinteyu.hhsales.client.activity.IClientProbablyInfoActivityView;
import com.hhsales.zzxinteyu.hhsales.client.bean.ClientData;
import com.hhsales.zzxinteyu.hhsales.client.bean.PageClientInfo;
import com.hhsales.zzxinteyu.hhsales.client.bean.Purchase;
import com.hhsales.zzxinteyu.hhsales.client.bean.Transaction;
import com.hhsales.zzxinteyu.hhsales.client.model.ClientProbablyInfoModel;
import com.hhsales.zzxinteyu.hhsales.client.model.IClientProbablyInfoModel;
import com.hhsales.zzxinteyu.hhsales.utlis.ClientInfoDataDictionary;

import org.json.JSONArray;
import org.json.JSONObject;

import okhttp3.Request;

/**
 * Created by Huairen on 2018/6/21.
 */

public class ClientProbablyInfoPresenter extends BasePresenter<IClientProbablyInfoActivityView> {
    private IClientProbablyInfoModel iClientProbablyInfoModel = new ClientProbablyInfoModel();

    //根据id查询客户户信息
    public void getClientInfo(final String client_id) {
        iClientProbablyInfoModel.getClientInfo(client_id, new ResultCallback<PageClientInfo<ClientData>>() {
            @Override
            public void onError(Request request, Exception e) {
                mViewRef.get().showError();
            }

            @Override
            public void onResponse(PageClientInfo<ClientData> response){
                mViewRef.get().setClientInfo(response);
                mViewRef.get().getPurchase(client_id);
                //LogUtils.i("根据id查询客户信息"+GsonUtil.GsonString(response));
            }
        });

    }
    //客户id查询意向房间
    public void findIntentionByClientId(final String client_id){
        iClientProbablyInfoModel.findIntentionByClientId(client_id, new ResultCallback<Purchase>() {
            @Override
            public void onError(Request request, Exception e) {
                mViewRef.get().showError();
                LogUtils.i("查询购房意向失败"+e);
            }

            @Override
            public void onResponse(Purchase response) throws Exception {
                // LogUtils.i("查询购房意向成功"+GsonUtil.GsonString(response));

                mViewRef.get().setPurchase(response);
                mViewRef.get().getInteraction(client_id);

            }
        });
    }

    //根据id查询数据字典
    public void findSysDictionaryItemByPk(final String id) {
        iClientProbablyInfoModel.getFindSysDictionaryItemByPk(id, new ResultCallback<Dictionary<DictionaryData>>() {
            @Override
            public void onError(Request request, Exception e) {
                LogUtils.i("id查询数据字典失败" + e);

            }
            @Override
            public void onResponse( Dictionary<DictionaryData> response) {
                LogUtils.i("当前数据id"+id);
                LogUtils.i("id查询数据字典成成功" + GsonUtil.GsonString(response));
                if(response.getData().getFk_dictionary_id().equals("15"))
                mViewRef.get().show_mTv_purchase_use(response.getData().getName());
//                if(response.getData().getFk_dictionary_id().equals("5"))
//                    mViewRef.get().showMarriage(response.getData().getName());
//                if(response.getData().getFk_dictionary_id().equals("6"))
//                    mViewRef.get().showComprehensive_salary(response.getData().getName());
//                if(response.getData().getFk_dictionary_id().equals("14"))
//                    mViewRef.get().showFk_age(response.getData().getName());
                if(response.getData().getFk_dictionary_id().equals("8"))
                    mViewRef.get().show_mTv_purchase_room_type(response.getData().getName());
//                    mViewRef.get().showFk_use(response.getData().getName());
//                if(response.getData().getFk_dictionary_id().equals("4"))
//                    mViewRef.get().showFk_follow_stage(response.getData().getName());
            }
        });
    }

    //一次性获取数据字典
    public void findListSysDictionary(String string, final String client_id) {
        iClientProbablyInfoModel.getFindListSysDictionary(string, new ResultCallback<String>() {
            @Override
            public void onError(Request request, Exception e) {
                LogUtils.i("一次性获取数据字典失败"+e);
                //mViewRef.get().initTabDataNO();
                mViewRef.get().showError();
            }

            @Override
            public void onResponse(String response) throws Exception {
                //LogUtils.i("一次性获取数据字典成功"+response);
                JSONObject jsonObject = new JSONObject(response);
                JSONArray jsonArray;
                if(jsonObject.getString("message").equals("根据外键id查询数据字典明细信息成功")){
                    JSONObject objectData=jsonObject.getJSONObject("data");
                    String[] strings;
                    String[] strings_id;

                    jsonArray=objectData.getJSONArray("4");//跟进阶段
                    strings = new String[jsonArray.length()];
                    strings_id = new String[jsonArray.length()];
                    if (jsonArray.length()>0){
                        JSONObject object;
                        for (int i=0;i<jsonArray.length();i++){
                            object=jsonArray.getJSONObject(i);
                            strings[i]=object.getString("name");
                            strings_id[i]=object.getString("dictionary_item_id");
                        }
                        ClientInfoDataDictionary.follow_stage=strings;
                        ClientInfoDataDictionary.follow_stage_id = strings_id;
                        LogUtils.i("跟进阶段数据字典"+ClientInfoDataDictionary.follow_stage.length);
                    }

                    jsonArray=objectData.getJSONArray("5");//婚姻状况
                    strings = new String[jsonArray.length()];
                    strings_id = new String[jsonArray.length()];
                    if (jsonArray.length()>0){
                        JSONObject object;
                        for (int i=0;i<jsonArray.length();i++){
                            object=jsonArray.getJSONObject(i);
                            strings[i]=object.getString("name");
                            strings_id[i]=object.getString("dictionary_item_id");
                        }
                        ClientInfoDataDictionary.marriage=strings;
                        ClientInfoDataDictionary.marriage_id = strings_id;
                    }

                    jsonArray=objectData.getJSONArray("6");//综合年薪
                    strings = new String[jsonArray.length()];
                    strings_id = new String[jsonArray.length()];
                    if (jsonArray.length()>0){
                        JSONObject object;
                        for (int i=0;i<jsonArray.length();i++){
                            object=jsonArray.getJSONObject(i);
                            strings[i]=object.getString("name");
                            strings_id[i]=object.getString("dictionary_item_id");
                        }
                        ClientInfoDataDictionary.comprehensive_salary=strings;
                        ClientInfoDataDictionary.comprehensive_salary_id = strings_id;
                    }


                    jsonArray=objectData.getJSONArray("8");//房间类型
                    strings = new String[jsonArray.length()];
                    strings_id = new String[jsonArray.length()];
                    if (jsonArray.length()>0){
                        JSONObject object;
                        for (int i=0;i<jsonArray.length();i++){
                            object=jsonArray.getJSONObject(i);
                            strings[i]=object.getString("name");
                            strings_id[i]=object.getString("dictionary_item_id");
                        }
                        ClientInfoDataDictionary.room_type=strings;
                        ClientInfoDataDictionary.room_type_id = strings_id;
                    }


                    jsonArray=objectData.getJSONArray("12");//客户分组
                    strings = new String[jsonArray.length()];
                    strings_id = new String[jsonArray.length()];
                    if (jsonArray.length()>0){
                        JSONObject object;
                        for (int i=0;i<jsonArray.length();i++){
                            object=jsonArray.getJSONObject(i);
                            strings[i]=object.getString("name");
                            strings_id[i]=object.getString("dictionary_item_id");
                        }
                        ClientInfoDataDictionary.client_group=strings;
                        ClientInfoDataDictionary.client_group_id = strings_id;
                    }

                    jsonArray=objectData.getJSONArray("14");//年龄阶段
                    strings = new String[jsonArray.length()];
                    strings_id = new String[jsonArray.length()];
                    if (jsonArray.length()>0){
                        JSONObject object;
                        for (int i=0;i<jsonArray.length();i++){
                            object=jsonArray.getJSONObject(i);
                            strings[i]=object.getString("name");
                            strings_id[i]=object.getString("dictionary_item_id");
                        }
                        ClientInfoDataDictionary.age_paragraph = strings;
                        ClientInfoDataDictionary.age_paragraph_id = strings_id;
                    }

                    jsonArray=objectData.getJSONArray("15");//购房用途
                    strings = new String[jsonArray.length()];
                    strings_id = new String[jsonArray.length()];
                    if (jsonArray.length()>0){
                        JSONObject object;
                        for (int i=0;i<jsonArray.length();i++){
                            object=jsonArray.getJSONObject(i);
                            strings[i]=object.getString("name");
                            strings_id[i]=object.getString("dictionary_item_id");
                        }
                        ClientInfoDataDictionary.purchase_use = strings;
                        ClientInfoDataDictionary.purchase_use_id = strings_id;
                    }

                }
                 mViewRef.get().getClientInfo(client_id);
            }
        });

    }
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
