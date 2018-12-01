package com.hhsales.zzxinteyu.hhsales.client.bean;

/**
 * Created by Huairen on 2018/4/19.
 */

public class ListTrack {
            public String client_track_id;// null,
        public String fk_client_id;// null,
        public String contact_time;// 1523948176000,
    public ListTrack() {
    }

    public String getContact_time() {
        return contact_time;
    }

    public void setContact_time(String contact_time) {
        this.contact_time = contact_time;
    }

    public String getClient_track_id() {
        return client_track_id;
    }

    public void setClient_track_id(String client_track_id) {
        this.client_track_id = client_track_id;
    }

    public String getFk_client_id() {
        return fk_client_id;
    }

    public void setFk_client_id(String fk_client_id) {
        this.fk_client_id = fk_client_id;
    }
}
