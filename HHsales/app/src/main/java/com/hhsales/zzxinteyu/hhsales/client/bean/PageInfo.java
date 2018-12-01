package com.hhsales.zzxinteyu.hhsales.client.bean;

/**
 * Created by acer on 2018/4/11.
 */

public class PageInfo {
    private String cpage;// 1,
    private String page_size;// 30,
    private String total_page;// 1,
    private String total_count;// 0,
    private String index_count;// 0,
    private boolean isnext;// false,
    private boolean isbefore;// false

    public PageInfo() {
    }

    public String getCpage() {
        return cpage;
    }

    public void setCpage(String cpage) {
        this.cpage = cpage;
    }

    public String getPage_size() {
        return page_size;
    }

    public void setPage_size(String page_size) {
        this.page_size = page_size;
    }

    public String getTotal_page() {
        return total_page;
    }

    public void setTotal_page(String total_page) {
        this.total_page = total_page;
    }

    public String getTotal_count() {
        return total_count;
    }

    public void setTotal_count(String total_count) {
        this.total_count = total_count;
    }

    public String getIndex_count() {
        return index_count;
    }

    public void setIndex_count(String index_count) {
        this.index_count = index_count;
    }

    public boolean getIsnext() {
        return isnext;
    }

    public void setIsnext(boolean isnext) {
        this.isnext = isnext;
    }

    public boolean isIsbefore() {
        return isbefore;
    }

    public void setIsbefore(boolean isbefore) {
        this.isbefore = isbefore;
    }
}
