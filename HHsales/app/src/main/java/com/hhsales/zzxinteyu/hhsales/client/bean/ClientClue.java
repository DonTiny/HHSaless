package com.hhsales.zzxinteyu.hhsales.client.bean;

/**
 * Created by Administrator on 2018/4/19.
 */

public class ClientClue {
    private String client_Clue_id;
    private String client_Clue_code;
    private String client_Clue_cognitive;//	认知途径455ea1eb-eb75-41ab-80e0-c9d176c5e5fe
    private String client_Clue_describe;//		线索描述
    private String client_Clue_note;//		线索备注
    private String client_Clue_source;//		线索来源
    private String client_Clue_subject;//    线索主题
    private String fk_client_info_id;

    public String getClient_Clue_id() {
        return client_Clue_id;
    }

    public void setClient_Clue_id(String client_Clue_id) {
        this.client_Clue_id = client_Clue_id;
    }

    public String getClient_Clue_code() {
        return client_Clue_code;
    }

    public void setClient_Clue_code(String client_Clue_code) {
        this.client_Clue_code = client_Clue_code;
    }

    public String getClient_Clue_cognitive() {
        return client_Clue_cognitive;
    }

    public void setClient_Clue_cognitive(String client_Clue_cognitive) {
        this.client_Clue_cognitive = client_Clue_cognitive;
    }

    public String getClient_Clue_describe() {
        return client_Clue_describe;
    }

    public void setClient_Clue_describe(String client_Clue_describe) {
        this.client_Clue_describe = client_Clue_describe;
    }

    public String getClient_Clue_note() {
        return client_Clue_note;
    }

    public void setClient_Clue_note(String client_Clue_note) {
        this.client_Clue_note = client_Clue_note;
    }

    public String getClient_Clue_source() {
        return client_Clue_source;
    }

    public void setClient_Clue_source(String client_Clue_source) {
        this.client_Clue_source = client_Clue_source;
    }

    public String getClient_Clue_subject() {
        return client_Clue_subject;
    }

    public void setClient_Clue_subject(String client_Clue_subject) {
        this.client_Clue_subject = client_Clue_subject;
    }

    public String getFk_client_info_id() {
        return fk_client_info_id;
    }

    public void setFk_client_info_id(String fk_client_info_id) {
        this.fk_client_info_id = fk_client_info_id;
    }
}
