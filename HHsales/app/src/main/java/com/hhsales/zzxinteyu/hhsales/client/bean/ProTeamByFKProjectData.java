package com.hhsales.zzxinteyu.hhsales.client.bean;

/**
 * Created by Huairen on 2018/4/25.
 */

public class ProTeamByFKProjectData {
   private String staff_id;// 9f9c9dbb-99b0-4bc4-946a-930300faefa0,
    private String         team_id;// aa39be0b-2b6c-40c3-9ee1-8297bee94f9c,
    private  SysStaff       sysStaff;//

    public ProTeamByFKProjectData() {
    }

    public String getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(String staff_id) {
        this.staff_id = staff_id;
    }

    public String getTeam_id() {
        return team_id;
    }

    public void setTeam_id(String team_id) {
        this.team_id = team_id;
    }

    public SysStaff getSysStaff() {
        return sysStaff;
    }

    public void setSysStaff(SysStaff sysStaff) {
        this.sysStaff = sysStaff;
    }
}
