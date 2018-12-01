package com.hhsales.zzxinteyu.hhsales.room_manage.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/11/13.
 */

public class RoomData {
   private Building building;
    private List<Room> listRoom;
    private List<Unit> listUnit;

    public RoomData() {
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public List<Room> getListRoom() {
        return listRoom;
    }

    public void setListRoom(List<Room> listRoom) {
        this.listRoom = listRoom;
    }

    public List<Unit> getListUnit() {
        return listUnit;
    }

    public void setListUnit(List<Unit> listUnit) {
        this.listUnit = listUnit;
    }
}
