package com.hhsales.zzxinteyu.hhsales.room_manage.bean;

/**
 * Created by acer on 2018/4/18.
 */

public class ProjectNextLevel {
    //父级ID
    private String fk_project_id;
    //值
    private String name;
    //ID
    private String building_id;

    public String getFk_project_id() {
        return fk_project_id;
    }

    public void setFk_project_id(String fk_project_id) {
        this.fk_project_id = fk_project_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBuilding_id() {
        return building_id;
    }

    public void setBuilding_id(String building_id) {
        this.building_id = building_id;
    }
}
