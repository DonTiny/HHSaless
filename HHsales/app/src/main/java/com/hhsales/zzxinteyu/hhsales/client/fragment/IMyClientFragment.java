package com.hhsales.zzxinteyu.hhsales.client.fragment;

import com.hhsales.zzxinteyu.hhsales.client.bean.ClientData;
import com.hhsales.zzxinteyu.hhsales.client.bean.PageClientInfo;

import java.util.List;

/**
 * Created by Huairen on 2018/6/20.
 */

public interface IMyClientFragment {
    void showInitData();
    void showPageClientInfo(PageClientInfo<List<ClientData>> pageClientInfo);
    void showInitData(int cpage,int page_size,int type);
    void showPageClientInfoError();

    void stopTopBottomLoad();
}
