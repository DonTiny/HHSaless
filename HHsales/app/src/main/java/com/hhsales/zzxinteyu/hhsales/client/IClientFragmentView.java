package com.hhsales.zzxinteyu.hhsales.client;

import com.hhsales.zzxinteyu.hhsales.bean.ProItemName;
import com.hhsales.zzxinteyu.hhsales.bean.UserPermissions;

/**
 * Created by Administrator on 2018/11/16.
 */

public interface IClientFragmentView {
    void setPageData(ProItemName pageData);

    void setPermissions(UserPermissions permissions);

}
