package com.hhsales.zzxinteyu.hhsales.client_follow.ui;

import com.hhsales.zzxinteyu.hhsales.bean.ProItemName;
import com.hhsales.zzxinteyu.hhsales.bean.UserPermissions;

/**
 * Created by Administrator on 2018/11/15.
 */

public interface IFollowView {
    void setPageData(ProItemName pageData);
    void setPermissions(UserPermissions permissions);
}
