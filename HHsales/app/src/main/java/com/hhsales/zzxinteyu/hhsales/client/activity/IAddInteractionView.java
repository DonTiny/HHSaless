package com.hhsales.zzxinteyu.hhsales.client.activity;

import java.util.Map;

/**
 * Created by Huairen on 2018/6/25.
 */

public interface IAddInteractionView {
    Map<String,String> getViewText();

    void addClinetTrackResults(int results);
}
