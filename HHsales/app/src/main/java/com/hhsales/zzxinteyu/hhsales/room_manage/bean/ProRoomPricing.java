package com.hhsales.zzxinteyu.hhsales.room_manage.bean;

/**
 * Created by acer on 2018/4/11.
 */

public class ProRoomPricing {

    //(value = "房间价格表")
   private String room_pricing_id;

    //(value = "建筑单价(万元)")
    private  double building_price;

    //(value = "套内单价（万元）")
    private  double within_price;
    //(value = "标准总价（万元）")
    private  double standard_total;

    //(value = "定价时间")
    private   String price_time;

    //(value = "房间id")
    private String fk_room_id;

    //(value = "调价方案表id")
    private  String fk_pricing_secheme_id;

    //(value = "状态（0有效，1过期）")
    private   //(value = "计价方式(1建筑面积，2套内面积)")
    int denominated_type;
    //(value = "创建人")
    private String creator;

    //(value = "创建时间")
    private  String created_time;

    //(value = "修改人")
    private   String modifier;

    //(value = "修改时间")
    private  String modified_time;

    //(value = "是否逻辑删除")
    int isdeleted;

    public ProRoomPricing() {
    }

    public String getRoom_pricing_id() {
        return room_pricing_id;
    }

    public void setRoom_pricing_id(String room_pricing_id) {
        this.room_pricing_id = room_pricing_id;
    }

    public double getBuilding_price() {
        return building_price;
    }

    public void setBuilding_price(double building_price) {
        this.building_price = building_price;
    }

    public double getWithin_price() {
        return within_price;
    }

    public void setWithin_price(double within_price) {
        this.within_price = within_price;
    }

    public double getStandard_total() {
        return standard_total;
    }

    public void setStandard_total(double standard_total) {
        this.standard_total = standard_total;
    }

    public String getPrice_time() {
        return price_time;
    }

    public void setPrice_time(String price_time) {
        this.price_time = price_time;
    }

    public String getFk_room_id() {
        return fk_room_id;
    }

    public void setFk_room_id(String fk_room_id) {
        this.fk_room_id = fk_room_id;
    }

    public String getFk_pricing_secheme_id() {
        return fk_pricing_secheme_id;
    }

    public void setFk_pricing_secheme_id(String fk_pricing_secheme_id) {
        this.fk_pricing_secheme_id = fk_pricing_secheme_id;
    }

    public int getDenominated_type() {
        return denominated_type;
    }

    public void setDenominated_type(int denominated_type) {
        this.denominated_type = denominated_type;
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
}
