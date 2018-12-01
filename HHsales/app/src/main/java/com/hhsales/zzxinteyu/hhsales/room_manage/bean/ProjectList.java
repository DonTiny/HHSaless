package com.hhsales.zzxinteyu.hhsales.room_manage.bean;

/**
 * Created by acer on 2018/4/18.
 */

public class ProjectList {

    //父级ID
    private String fk_parent_item;
    //值
    private String item_name;
    //ID
    private String project_id;

    public String getFk_parent_item() {
        return fk_parent_item;
    }

    public void setFk_parent_item(String fk_parent_item) {
        this.fk_parent_item = fk_parent_item;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getProject_id() {
        return project_id;
    }

    public void setProject_id(String project_id) {
        this.project_id = project_id;
    }
}
