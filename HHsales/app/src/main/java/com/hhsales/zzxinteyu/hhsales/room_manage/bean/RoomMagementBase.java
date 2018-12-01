package com.hhsales.zzxinteyu.hhsales.room_manage.bean;

import java.util.ArrayList;

/**
 * Created by acer on 2018/3/31.
 */

public class RoomMagementBase {
    private String building_id;
    //楼栋名称
    private String building_name;
    //项目名称
    private String project_name;
    //装修标准
    private String decoration_standard;
    //房间结构
    private String room_structure;
    //房间朝向
    private String orientation;
    //户型
    private String hourse_type_name;
    private String room_id;
    private String room_pricing_id;

    private ProRoomPricing proRoomPricing;

    private Room proRoom;
    //平面图信息
    private ArrayList<FileLogCustom> listFileLog;

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getDecoration_standard() {
        return decoration_standard;
    }

    public void setDecoration_standard(String decoration_standard) {
        this.decoration_standard = decoration_standard;
    }

    public String getRoom_structure() {
        return room_structure;
    }

    public void setRoom_structure(String room_structure) {
        this.room_structure = room_structure;
    }

    public ProRoomPricing getProRoomPricing() {
        return proRoomPricing;
    }

    public void setProRoomPricing(ProRoomPricing proRoomPricing) {
        this.proRoomPricing = proRoomPricing;
    }

    public Room getProRoom() {
        return proRoom;
    }

    public void setProRoom(Room proRoom) {
        this.proRoom = proRoom;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public String getBuilding_name() {
        return building_name;
    }

    public void setBuilding_name(String building_name) {
        this.building_name = building_name;
    }

    public ArrayList<FileLogCustom> getListFileLog() {
        return listFileLog;
    }

    public void setListFileLog(ArrayList<FileLogCustom> listFileLog) {
        this.listFileLog = listFileLog;
    }

    public String getBuilding_id() {
        return building_id;
    }

    public void setBuilding_id(String building_id) {
        this.building_id = building_id;
    }

    public String getHourse_type_name() {
        return hourse_type_name;
    }

    public void setHourse_type_name(String hourse_type_name) {
        this.hourse_type_name = hourse_type_name;
    }

    public String getRoom_id() {
        return room_id;
    }

    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }

    public String getRoom_pricing_id() {
        return room_pricing_id;
    }

    public void setRoom_pricing_id(String room_pricing_id) {
        this.room_pricing_id = room_pricing_id;
    }
}
