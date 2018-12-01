package com.hhsales.zzxinteyu.hhsales.login.ui;


import com.example.lib_common.bean.user.UserBean;
import com.example.lib_common.inteface.IShowLoading;

import java.util.Map;

/**
 * Created by Administrator on 2018/3/30.
 */

public interface ILoginView extends IShowLoading {

    @Override
    void showLoading();
    //获取账号密码
    //该方法实现数据现在
    Map<String,String> getUserNameOrPsw();
    void startMeun(UserBean userBean);
    void  LoginNo();

}
