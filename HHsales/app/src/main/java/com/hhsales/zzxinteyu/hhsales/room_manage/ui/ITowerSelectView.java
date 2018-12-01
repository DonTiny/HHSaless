package com.hhsales.zzxinteyu.hhsales.room_manage.ui;

import com.hhsales.zzxinteyu.hhsales.bean.ProItemName;
import com.hhsales.zzxinteyu.hhsales.room_manage.bean.Building;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/11/14.
 */

public interface ITowerSelectView {

    void initNode(ProItemName proItemName);

    void initBuiding(Map<String, List<Building>> listMap);

    void showToast(String message);
}
