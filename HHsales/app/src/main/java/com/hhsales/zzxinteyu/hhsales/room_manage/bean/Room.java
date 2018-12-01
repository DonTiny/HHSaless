package com.hhsales.zzxinteyu.hhsales.room_manage.bean;

/**
 * Created by Administrator on 2018/11/13.
 */

public class Room {
   //(value = "主键")
  private   String room_id;

   //(value = "房间名称")
   private   String room_name;

   //(value = "所属项目")
   private    String fk_project_id;

   //(value = "楼栋id")
   private    String fk_building_id;

   //(value = "装修标准Id（数据字典）")
   private    String fk_decoration_standard;

   //(value = "户型id")
   private  String fk_hourse_type_id;

   //(value = "房间结构(数据字典)")
   private   String fk_room_structure;

   //(value = "楼层")
   private  int storey;

   //(value = "房间编号")
   private String code;

   //(value = "产品类型(数据字典)")
   private String fk_project_type;

   //(value = "房号")
   private String room_number;

   //(value = "建筑面积(平方米)")
   private  double building_area;

   //(value = "套内面积(平方米)")
   private  double within_area;

   //(value = "建筑实测(平方米)")
   private double building_measure;

   //(value = "套内实测(平方米)")
   private   double within_measure;

   //(value = "阳台面积(平方米)")
   private  double balcony_area;

   //(value = "朝向(数据字典)")
   private   String fk_orientation;

   //(value = "装修单价(元/平方米)")
   private double decorate_price;

   //(value = "装修总价")
   private  double decorate_total;

   //(value = "创建人Id")
   private  String creator_id;

   //(value = "创建人")
   private String creator;

   //(value = "创建时间")
   private String created_time;

   //(value = "修改人")
   private  String modifier;

   //(value = "修改时间")
   private  String modified_time;

   //(value = "是否逻辑删除")
   private  int isdeleted;
   //(value = "单元名称")
   private  String unit_name;
   //(value = "状态【control,booking,appointment,reserved,smallOrder,subscribe,signed,sale】")
   private  int status;

    public Room() {
    }

    public String getRoom_id() {
        return room_id;
    }

    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public String getFk_project_id() {
        return fk_project_id;
    }

    public void setFk_project_id(String fk_project_id) {
        this.fk_project_id = fk_project_id;
    }

    public String getFk_building_id() {
        return fk_building_id;
    }

    public void setFk_building_id(String fk_building_id) {
        this.fk_building_id = fk_building_id;
    }

    public String getFk_decoration_standard() {
        return fk_decoration_standard;
    }

    public void setFk_decoration_standard(String fk_decoration_standard) {
        this.fk_decoration_standard = fk_decoration_standard;
    }

    public String getFk_hourse_type_id() {
        return fk_hourse_type_id;
    }

    public void setFk_hourse_type_id(String fk_hourse_type_id) {
        this.fk_hourse_type_id = fk_hourse_type_id;
    }

    public String getFk_room_structure() {
        return fk_room_structure;
    }

    public void setFk_room_structure(String fk_room_structure) {
        this.fk_room_structure = fk_room_structure;
    }

    public int getStorey() {
        return storey;
    }

    public void setStorey(int storey) {
        this.storey = storey;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFk_project_type() {
        return fk_project_type;
    }

    public void setFk_project_type(String fk_project_type) {
        this.fk_project_type = fk_project_type;
    }

    public String getRoom_number() {
        return room_number;
    }

    public void setRoom_number(String room_number) {
        this.room_number = room_number;
    }

    public double getBuilding_area() {
        return building_area;
    }

    public void setBuilding_area(double building_area) {
        this.building_area = building_area;
    }

    public double getWithin_area() {
        return within_area;
    }

    public void setWithin_area(double within_area) {
        this.within_area = within_area;
    }

    public double getBuilding_measure() {
        return building_measure;
    }

    public void setBuilding_measure(double building_measure) {
        this.building_measure = building_measure;
    }

    public double getWithin_measure() {
        return within_measure;
    }

    public void setWithin_measure(double within_measure) {
        this.within_measure = within_measure;
    }

    public double getBalcony_area() {
        return balcony_area;
    }

    public void setBalcony_area(double balcony_area) {
        this.balcony_area = balcony_area;
    }

    public String getFk_orientation() {
        return fk_orientation;
    }

    public void setFk_orientation(String fk_orientation) {
        this.fk_orientation = fk_orientation;
    }

    public double getDecorate_price() {
        return decorate_price;
    }

    public void setDecorate_price(double decorate_price) {
        this.decorate_price = decorate_price;
    }

    public double getDecorate_total() {
        return decorate_total;
    }

    public void setDecorate_total(double decorate_total) {
        this.decorate_total = decorate_total;
    }

    public String getCreator_id() {
        return creator_id;
    }

    public void setCreator_id(String creator_id) {
        this.creator_id = creator_id;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreated_time() {
        return created_time;
    }

    public void setCreated_time(String created_time) {
        this.created_time = created_time;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public String getModified_time() {
        return modified_time;
    }

    public void setModified_time(String modified_time) {
        this.modified_time = modified_time;
    }

    public int getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(int isdeleted) {
        this.isdeleted = isdeleted;
    }

    public String getUnit_name() {
        return unit_name;
    }

    public void setUnit_name(String unit_name) {
        this.unit_name = unit_name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
