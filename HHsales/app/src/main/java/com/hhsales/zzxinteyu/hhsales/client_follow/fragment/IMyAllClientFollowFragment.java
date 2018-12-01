package com.hhsales.zzxinteyu.hhsales.client_follow.fragment;

import com.hhsales.zzxinteyu.hhsales.client.bean.ClientData;
import com.hhsales.zzxinteyu.hhsales.client.bean.PageClientInfo;

import java.util.List;

/**
 * Created by Administrator on 2018/10/30.
 */

public interface IMyAllClientFollowFragment {
    void showInitData();
    void showPageClientInfo(PageClientInfo<List<ClientData>> pageClientInfo);
    void showInitData(int cpage,int page_size,int type);
    void showError();
    void showLoading();
    void showSuccess();
    void showEmpty();
}
