package com.hhsales.zzxinteyu.hhsales.my.bean;

/**
 * Created by Administrator on 2018/11/16.
 */

public class QueryParams {

   private String default_order;// null
    private String field;// "*"
    private String  field_pk;// null
    private String  field_value;// " dct.next_contact_time &lt;= &#39;2018-11-16&#39;"
    private int index_count;// 0
    private String  join;// ""
    private String  order;// ""
    private int page_size;// 30
    private String   table;// null
    private String   where;// " dct.fk_salesman_id=&#39;90a075fc-a46f-4d42-8228-a75eb49e3452&#39;"

    public QueryParams() {
    }

    public String getDefault_order() {
        return default_order;
    }

    public void setDefault_order(String default_order) {
        this.default_order = default_order;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getField_pk() {
        return field_pk;
    }

    public void setField_pk(String field_pk) {
        this.field_pk = field_pk;
    }

    public String getField_value() {
        return field_value;
    }

    public void setField_value(String field_value) {
        this.field_value = field_value;
    }

    public int getIndex_count() {
        return index_count;
    }

    public void setIndex_count(int index_count) {
        this.index_count = index_count;
    }

    public String getJoin() {
        return join;
    }

    public void setJoin(String join) {
        this.join = join;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public int getPage_size() {
        return page_size;
    }

    public void setPage_size(int page_size) {
        this.page_size = page_size;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }
}
