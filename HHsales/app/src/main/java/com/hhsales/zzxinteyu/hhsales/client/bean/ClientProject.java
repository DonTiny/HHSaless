package com.hhsales.zzxinteyu.hhsales.client.bean;

/**
 * Created by Huairen on 2018/4/20.
 */

public class ClientProject {
     private String  client_project_id  ;// null,
     private String        fk_project_id  ;//  fc8529b3-7eac-40d7-a833-4a414fefcc94 ,
    private String         fk_client_id  ;// null,
    private String       fk_salesman_id  ;//  9f9c9dbb-99b0-4bc4-946a-930300faefa0

    public ClientProject() {
    }

    public String getClient_project_id() {
        return client_project_id;
    }

    public void setClient_project_id(String client_project_id) {
        this.client_project_id = client_project_id;
    }

    public String getFk_project_id() {
        return fk_project_id;
    }

    public void setFk_project_id(String fk_project_id) {
        this.fk_project_id = fk_project_id;
    }

    public String getFk_client_id() {
        return fk_client_id;
    }

    public void setFk_client_id(String fk_client_id) {
        this.fk_client_id = fk_client_id;
    }

    public String getFk_salesman_id() {
        return fk_salesman_id;
    }

    public void setFk_salesman_id(String fk_salesman_id) {
        this.fk_salesman_id = fk_salesman_id;
    }
}
