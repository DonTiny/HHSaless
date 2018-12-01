package com.hhsales.zzxinteyu.hhsales.my.bean;

import com.hhsales.zzxinteyu.hhsales.bean.ProItemName;
import com.hhsales.zzxinteyu.hhsales.client.bean.ClientInfo;

/**
 * Created by Administrator on 2018/11/16.
 */

public class MyTaskData {
    private String client_group;// "B类客户"
    private String client_track_id;// "66f7095f-ff4a-44de-82e3-187f5f818e0e"
    private String follow_stage;// "转客户"
    private ClientInfo clientInfo;
    private  ClientTrack clientTrack;
    private ProItem proItem;

    public MyTaskData() {
    }

    public String getClient_group() {
        return client_group;
    }

    public void setClient_group(String client_group) {
        this.client_group = client_group;
    }

    public String getClient_track_id() {
        return client_track_id;
    }

    public void setClient_track_id(String client_track_id) {
        this.client_track_id = client_track_id;
    }

    public String getFollow_stage() {
        return follow_stage;
    }

    public void setFollow_stage(String follow_stage) {
        this.follow_stage = follow_stage;
    }

    public ClientInfo getClientInfo() {
        return clientInfo;
    }

    public void setClientInfo(ClientInfo clientInfo) {
        this.clientInfo = clientInfo;
    }

    public ClientTrack getClientTrack() {
        return clientTrack;
    }

    public void setClientTrack(ClientTrack clientTrack) {
        this.clientTrack = clientTrack;
    }

    public ProItem getProItem() {
        return proItem;
    }

    public void setProItem(ProItem proItem) {
        this.proItem = proItem;
    }
}
