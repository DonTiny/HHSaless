package com.hhsales.zzxinteyu.hhsales.client.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/4/18 0018.
 */

public class ClientData {
    private String client_id;
    private ClientInfo clientInfo;
    private ClientClue clientClue;
    private List<ListTrack> listTrack;
    private ClientProject clientProject;
   private String ry_follow_stage;//  看情况 ,
    private String ry_use;// null,
    private String ry_marriage;// null,
    private String ry_project_name;// null,
    private String ry_salesman;// null,
    private String ry_annual_salary;// null,
    private String ry_age;// null,
    private String ry_group;// null

    public ClientData() {
    }

    public ClientClue getClientClue() {
        return clientClue;
    }

    public void setClientClue(ClientClue clientClue) {
        this.clientClue = clientClue;
    }

    public String getRy_follow_stage() {
        return ry_follow_stage;
    }

    public void setRy_follow_stage(String ry_follow_stage) {
        this.ry_follow_stage = ry_follow_stage;
    }

    public String getRy_use() {
        return ry_use;
    }

    public void setRy_use(String ry_use) {
        this.ry_use = ry_use;
    }

    public String getRy_marriage() {
        return ry_marriage;
    }

    public void setRy_marriage(String ry_marriage) {
        this.ry_marriage = ry_marriage;
    }

    public String getRy_project_name() {
        return ry_project_name;
    }

    public void setRy_project_name(String ry_project_name) {
        this.ry_project_name = ry_project_name;
    }

    public String getRy_salesman() {
        return ry_salesman;
    }

    public void setRy_salesman(String ry_salesman) {
        this.ry_salesman = ry_salesman;
    }

    public String getRy_annual_salary() {
        return ry_annual_salary;
    }

    public void setRy_annual_salary(String ry_annual_salary) {
        this.ry_annual_salary = ry_annual_salary;
    }

    public String getRy_age() {
        return ry_age;
    }

    public void setRy_age(String ry_age) {
        this.ry_age = ry_age;
    }

    public String getRy_group() {
        return ry_group;
    }

    public void setRy_group(String ry_group) {
        this.ry_group = ry_group;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public ClientInfo getClientInfo() {
        return clientInfo;
    }

    public void setClientInfo(ClientInfo clientInfo) {
        this.clientInfo = clientInfo;
    }

    public ClientProject getClientProject() {
        return clientProject;
    }

    public void setClientProject(ClientProject clientProject) {
        this.clientProject = clientProject;
    }

    public List<ListTrack> getListTrack() {
        return listTrack;
    }

    public void setListTrack(List<ListTrack> listTrack) {
        this.listTrack = listTrack;
    }

   // public class ListTrack {
//        public String client_track_id;// null,
//        public String fk_client_id;// null,
//        public String fk_follow_stage;// null,
//        public String contact_time;// 1523948176000,
//        public String next_contact_time;// 1523980800000,
//        public String record;// null,
//        public String record_type;// 0,
//        public String creator_id;// null,
//        public String created_time;// null,
//        public String modifier;// null,
//        public String modified_time;// null,
//        public String isdeleted;// 0,
//        public String memo;// null,
//        public String creator;// null,
//        public String fk_salesman_id;// null
//
//        public ListTrack() {
//        }

}
