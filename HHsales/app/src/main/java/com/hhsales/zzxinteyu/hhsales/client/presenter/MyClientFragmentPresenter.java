package com.hhsales.zzxinteyu.hhsales.client.presenter;

import android.util.ArrayMap;

import com.example.lib_common.mvp.presenter.BasePresenter;
import com.example.lib_common.utils.LogUtils;
import com.example.lib_common.utils.okhttpUtils.ResultCallback;
import com.hhsales.zzxinteyu.hhsales.client.bean.ClientData;
import com.hhsales.zzxinteyu.hhsales.client.bean.PageClientInfo;
import com.hhsales.zzxinteyu.hhsales.client.fragment.IMyClientFragment;
import com.hhsales.zzxinteyu.hhsales.client.fragment.MyClientFragment;
import com.hhsales.zzxinteyu.hhsales.client.model.IMyClientFragmentModel;
import com.hhsales.zzxinteyu.hhsales.client.model.MyClientFragmentModel;

import java.util.List;
import java.util.Map;

import okhttp3.Request;

/**
 * Created by Huairen on 2018/6/20.
 */

public class MyClientFragmentPresenter extends BasePresenter<IMyClientFragment> {
    private IMyClientFragmentModel iMyClientFragmentModel = new MyClientFragmentModel();

    public void  setClientPageInfo(Map<String,String> map){
        iMyClientFragmentModel.getPageClientInfo(map, new ResultCallback<PageClientInfo<List<ClientData>>>() {
            @Override
            public void onError(Request request, Exception e) {
                LogUtils.i("分页查询客户失败"+e);

//                MyClientFragment.clientInfotPrl.finishLoadMore();
//                MyClientFragment.clientInfotPrl.finishRefresh();
//
                mViewRef.get().showPageClientInfoError();
                mViewRef.get().stopTopBottomLoad();
            }

            @Override
            public void onResponse(PageClientInfo<List<ClientData>> response)  {
                mViewRef.get().showPageClientInfo(response);
//                LogUtils.i("分页查询客户成功"+response);
            //    LogUtils.i("请求数据大小"+response.getData().size());

            }
        });
    }

    public void findClientInfoState2(Map<String,String> map){
        iMyClientFragmentModel.findClientInfoState2(map, new ResultCallback<PageClientInfo<List<ClientData>>>() {
            @Override
            public void onError(Request request, Exception e) {
                LogUtils.i("根据条件查询客户信息失败"+e);
                mViewRef.get().showPageClientInfoError();
                mViewRef.get().stopTopBottomLoad();
            }

            @Override
            public void onResponse(PageClientInfo<List<ClientData>> response) throws Exception {
                LogUtils.i("根据条件查询客户信息成功"+response);
                mViewRef.get().showPageClientInfo(response);

            }
        });
    }
//    private  Map<String,String> mapPage(int cpage, int page_size,int type){
//
//        Map<String, String> map = new ArrayMap<>();
//        map.put("baseModel.pageInfo.cpage", cpage+"");
//        map.put("baseModel.pageInfo.page_size", page_size+"");
//        map.put("advancedQueryList[1].fieldName", "pi.project_id");
//
//        map.put("advancedQueryList[1].fieldValue", "1a8ef8c3-bfc6-4fda-9a16-55f8b507a61f");
//
//        map.put("advancedQueryList[1].tempOperator", "QUERY");
//        map.put("advancedQueryList[2].fieldName", "sdi4.name");
//        map.put("advancedQueryList[2].fieldValue", "认购");
//        map.put("advancedQueryList[2].tempOperator", "QUERY");
//
//        map.put("baseModel.condition", type+"");
//        return map;
//    }
}
