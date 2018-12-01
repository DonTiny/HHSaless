package com.hhsales.zzxinteyu.hhsales.room_manage.bean;

/**
 * Created by Administrator on 2018/11/13.
 */

public class Unit {
   private String building_unit_id;// "47839ed7-b488-444c-b434-34367bf72244"
    private String created_time;// 1527584842000
    private String fk_building_id;// "e9f698ce-478b-4f65-8269-e322d9c3f970"
    private String unit_name;// "8单元"

    public Unit() {
    }

    public String getBuilding_unit_id() {
        return building_unit_id;
    }

    public void setBuilding_unit_id(String building_unit_id) {
        this.building_unit_id = building_unit_id;
    }

    public String getCreated_time() {
        return created_time;
    }

    public void setCreated_time(String created_time) {
        this.created_time = created_time;
    }

    public String getFk_building_id() {
        return fk_building_id;
    }

    public void setFk_building_id(String fk_building_id) {
        this.fk_building_id = fk_building_id;
    }

    public String getUnit_name() {
        return unit_name;
    }

    public void setUnit_name(String unit_name) {
        this.unit_name = unit_name;
    }
}
