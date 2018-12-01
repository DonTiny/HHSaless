package com.hhsales.zzxinteyu.hhsales.bean;

/**
 * Created by Huairen on 2018/4/25.
 */

public class ProItemNameData {
   private String fk_parent_item;// null,
    private String       item_name;// 百秒公寓,
    private String       project_id;// 1a606399-c3ea-483f-be8e-a4b6390efa18
    private int id;
    private int parent_id;
    public ProItemNameData() {
    }

    public String getFk_parent_item() {
        return fk_parent_item;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
