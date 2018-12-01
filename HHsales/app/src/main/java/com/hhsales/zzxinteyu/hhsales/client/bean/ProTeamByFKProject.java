package com.hhsales.zzxinteyu.hhsales.client.bean;

import java.util.List;

/**
 * Created by Huairen on 2018/4/25.
 */

public class ProTeamByFKProject {
   private String project_id;
   private String resultFlag;// 0,
    private String         message;// 查询项目团队成功,
    private List<ProTeamByFKProjectData> data;//

    public ProTeamByFKProject() {
    }

    public String getProject_id() {
        return project_id;
    }

    public void setProject_id(String project_id) {
        this.project_id = project_id;
    }

    public String getResultFlag() {
        return resultFlag;
    }

    public void setResultFlag(String resultFlag) {
        this.resultFlag = resultFlag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ProTeamByFKProjectData> getData() {
        return data;
    }

    public void setData(List<ProTeamByFKProjectData> data) {
        this.data = data;
    }
}
