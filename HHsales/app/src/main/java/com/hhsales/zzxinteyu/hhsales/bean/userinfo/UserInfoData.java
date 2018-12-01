package com.hhsales.zzxinteyu.hhsales.bean.userinfo;

import com.example.lib_common.bean.user.ListDept;
import com.example.lib_common.bean.user.ListRole;
import com.example.lib_common.bean.user.ListStaff;

import java.util.List;

/**
 * Created by Administrator on 2018/11/2.
 */

public class UserInfoData {
    private String user_id;// 9231bc12-4eb6-4365-8e60-5c71441930e0,
    private String user_name;// tanggang,
    private String staff_name;// null,
    private String portrait_path;// 2018\\201811\\20181101\\user\\9da77e26-cac8-426d-aa1a-84844993a7de.jpg,
    private String old_password;// null,
    private List<ListDept> listDept;
    private List<ListOrgan> listOrgan;
    private List<ListPro> listPro;
    private List<ListRole> listRole;
    private List<ListStaff> listStaff;
    private SysUser sysUser;

    public UserInfoData() {
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getStaff_name() {
        return staff_name;
    }

    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
    }

    public String getPortrait_path() {
        return portrait_path;
    }

    public void setPortrait_path(String portrait_path) {
        this.portrait_path = portrait_path;
    }

    public String getOld_password() {
        return old_password;
    }

    public void setOld_password(String old_password) {
        this.old_password = old_password;
    }

    public List<ListDept> getListDept() {
        return listDept;
    }

    public void setListDept(List<ListDept> listDept) {
        this.listDept = listDept;
    }

    public List<ListOrgan> getListOrgan() {
        return listOrgan;
    }

    public void setListOrgan(List<ListOrgan> listOrgan) {
        this.listOrgan = listOrgan;
    }

    public List<ListPro> getListPro() {
        return listPro;
    }

    public void setListPro(List<ListPro> listPro) {
        this.listPro = listPro;
    }

    public List<ListRole> getListRole() {
        return listRole;
    }

    public void setListRole(List<ListRole> listRole) {
        this.listRole = listRole;
    }

    public List<ListStaff> getListStaff() {
        return listStaff;
    }

    public void setListStaff(List<ListStaff> listStaff) {
        this.listStaff = listStaff;
    }

    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }
}
