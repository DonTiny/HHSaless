package com.hhsales.zzxinteyu.hhsales.utlis;

import com.hhsales.zzxinteyu.hhsales.client.bean.ProTeamByFKProject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Huairen on 2018/4/20.
 */

public class ClientInfoDataDictionary {
    public static String[] client_type = {"个体", "公司"};//客户类型
    public static String[] care_type = {"身份证", "护照"};//证件类型
    public static String[] sex = {"请选择","男", "女"};//性别
    public static String[] is_relation = {"请选择线是否为关系户","是关系户","不是关系户"};//性别
    public static String[] marriage =null;//婚姻状况
    public static String[] marriage_id =null;//婚姻状况
    public static String[] age_paragraph = null;//年龄段
    public static String[] age_paragraph_id = null;//年龄段

    public static String[] comprehensive_salary = null;//综合年薪(万元)
    public static String[] comprehensive_salary_id = null;//综合年薪(万元)

    public static String[] purchase_use = null;//购房用途
    public static String[] purchase_use_id = null;//购房用途

    public static String[] client_group_id =null;//客户分组
    public static String[] client_group =null;//客户分组

    public static String[] follow_stage = null;// 跟进阶段
    public static String[] follow_stage_id = null;// 跟进阶段

    public static String[] page_project = null;
    public static String[] page_project_id = null;
    public static List<ProTeamByFKProject> proTeamByFKProject=new ArrayList<>();//项目团队
    public static String[] salesman=null;//业务员
    public static String[] salesman_id=null;//业务员
    public static String[] interaction_type = {"电话", "来电","来访"};//交互类型类型

    public static String[] room_type=null;//房间类型

    public static String[] room_type_id=null;//房间类型id

    public static String[] client_search_types={"客户名称","客户类型","联系电话","法人代表","营业执照","性别"};

    public static String[] clue_origin = {"来电","来访","其他"};//线索来源
    public static String[] clue_cognitivepath = null;//认知途径
    public static String[] clue_cognitivepath_id = null;
    public static String[] clue_state = {"激活","转客户","转销售机会","废弃状态"};//线索状态
}
