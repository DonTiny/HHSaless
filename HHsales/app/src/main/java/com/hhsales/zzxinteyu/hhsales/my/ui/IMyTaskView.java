package com.hhsales.zzxinteyu.hhsales.my.ui;

import com.hhsales.zzxinteyu.hhsales.my.bean.MyTaskBean;

/**
 * Created by Administrator on 2018/11/16.
 */

public interface IMyTaskView  {
    void setMyTask(MyTaskBean myTask);
    void showError();
    void showLoading();
    void showSuccess();
    void showEmpty();
}
