package com.hhsales.zzxinteyu.hhsales.room_manage.bean;

/**
 * Created by acer on 2018/4/11.
 */

public class ProRoom {

    //建筑面积
    private int building_area;

    //位置（楼）
    private int storey;

    //位置（单位）
    private String unit_name;

    //位置（房间号）
    private String room_number;

    //主键id
    private String room_id;

    //楼栋id
    private String fk_building_id;

    //户型id
    private String fk_hourse_type_id;

    //产品类型(数据字典)
    private String fk_project_type;

    // 朝向(数据字典)
    private String fk_orientation;

    //套内面积(平方米)
    private int within_area;

    // 建筑实测(平方米)
    private int building_measure;

    // 套内实测(平方米)
    private int within_measure;

   // 装修单价(元/平方米)
    private int decorate_price;

    // 装修总价（装修款）
    private int decorate_total;

    // 房间名称
    private String room_name;

    //房间结构
    private String fk_room_structure;

    //装修标准
    private String fk_decoration_standard;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getBuilding_area() {
        return building_area;
    }

    public void setBuilding_area(int building_area) {
        this.building_area = building_area;
    }

    public int getStorey() {
        return storey;
    }

    public void setStorey(int storey) {
        this.storey = storey;
    }

    public String getUnit_name() {
        return unit_name;
    }

    public void setUnit_name(String unit_name) {
        this.unit_name = unit_name;
    }

    public String getRoom_number() {
       return room_number;
    }

    public void setRoom_number(String room_number) {
        this.room_number = room_number;
    }

    public String getRoom_id() {
        return room_id;
    }

    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }

    public String getFk_building_id() {
        return fk_building_id;
    }

    public void setFk_building_id(String fk_building_id) {
        this.fk_building_id = fk_building_id;
    }

    public String getFk_hourse_type_id() {
        return fk_hourse_type_id;
    }

    public void setFk_hourse_type_id(String fk_hourse_type_id) {
        this.fk_hourse_type_id = fk_hourse_type_id;
    }

    public String getFk_project_type() {
        return fk_project_type;
    }

    public void setFk_project_type(String fk_project_type) {
        this.fk_project_type = fk_project_type;
    }

    public String getFk_orientation() {
        return fk_orientation;
    }

    public void setFk_orientation(String fk_orientation) {
        this.fk_orientation = fk_orientation;
    }

    public int getWithin_area() {
        return within_area;
    }

    public void setWithin_area(int within_area) {
        this.within_area = within_area;
    }

    public int getBuilding_measure() {
        return building_measure;
    }

    public void setBuilding_measure(int building_measure) {
        this.building_measure = building_measure;
    }

    public int getWithin_measure() {
        return within_measure;
    }

    public void setWithin_measure(int within_measure) {
        this.within_measure = within_measure;
    }

    public int getDecorate_price() {
        return decorate_price;
    }

    public void setDecorate_price(int decorate_price) {
        this.decorate_price = decorate_price;
    }

    public int getDecorate_total() {
        return decorate_total;
    }

    public void setDecorate_total(int decorate_total) {
        this.decorate_total = decorate_total;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public String getFk_room_structure() {
        return fk_room_structure;
    }

    public void setFk_room_structure(String fk_room_structure) {
        this.fk_room_structure = fk_room_structure;
    }

    public String getFk_decoration_standard() {
        return fk_decoration_standard;
    }

    public void setFk_decoration_standard(String fk_decoration_standard) {
        this.fk_decoration_standard = fk_decoration_standard;
    }


}
