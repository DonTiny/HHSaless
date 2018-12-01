package com.hhsales.zzxinteyu.hhsales.client.bean;

public class ClientInfo{

    //@ApiModelProperty(value = "客户id")
    String client_id;

    //@ApiModelProperty(value = "客户名称")
    String client_name;

    //@ApiModelProperty(value = "客户类型（0个体、1公司）")
    int client_type;

    //@ApiModelProperty(value = "法人代表")
    String legal_repre;

    //@ApiModelProperty(value = "营业执照")
    String business_license;

    //@ApiModelProperty(value = "性别（0默认未指明、1男、2女）")
    int sex;

    //@ApiModelProperty(value = "证件类型（0、身份证1、护照）")
    int card_type;

    //@ApiModelProperty(value = "证件号码")
    String card_number;

    //@ApiModelProperty(value = "职业")
    String profession;

    //@ApiModelProperty(value = "跟进阶段（数据字典4）")
    String fk_follow_stage;

    //@ApiModelProperty(value = "移动电话")
    String mobile_tele;

    //@ApiModelProperty(value = "住宅电话")
    String homephone;

    //@ApiModelProperty(value = "办公电话")
    String work_phone;

    //@ApiModelProperty(value = "传真")
    String fax;

    //@ApiModelProperty(value = "综合年薪(万元，数据字典6)")
    String fk_annual_salary;
    //@DateTimeFormat(pattern="yyyy-MM-dd")
    //@ApiModelProperty(value = "出生日期")
    String birthday;

    //@ApiModelProperty(value = "国籍")
    String nationality;

    //@ApiModelProperty(value = "籍贯")
    String native_place;

    //@ApiModelProperty(value = "通讯地址")
    String address;

    //@ApiModelProperty(value = "婚姻(数据字典5)")
    String fk_marriage;

    //@ApiModelProperty(value = "邮编")
    String postcard;

    //@ApiModelProperty(value = "居住区域")
    String residential_zone;

    //@ApiModelProperty(value = "创建人id")
    String creator_id;

    //@ApiModelProperty(value = "创建人")
    String creator;

    //@ApiModelProperty(value = "创建时间")
    String created_time;

    //@ApiModelProperty(value = "修改人")
    String modifier;

    //@ApiModelProperty(value = "修改时间")
    String modified_time;

    //@ApiModelProperty(value = "是否逻辑删除(0存在、1删除)")
    int isdeleted;

    //@ApiModelProperty(value = "工作单位")
    String workplace;

    //@ApiModelProperty(value = "联络人")
    String contact;

    //@ApiModelProperty(value = "公司电话")
    String corp_phone;

    //@ApiModelProperty(value = "工作区域")
    String corp_area;

    //@ApiModelProperty(value = "状态(0线索，1普通客户，2销售机会，3签订合同，4完结)")
    int state;

    //@ApiModelProperty(value = "客户分组id（数据字典12）")
    String fk_group_id;

    //@ApiModelProperty(value = "邮箱")
    String email;

    //@ApiModelProperty(value = "年龄段（数据字典14）")
    String fk_age;

    //@ApiModelProperty(value = "购房用途(数据字典15)")
    String fk_use;


    public void setClient_id(String client_id){
        this.client_id=client_id;
    }

    public String getClient_id(){
        return client_id;
    }

    public void setClient_name(String client_name){
        this.client_name=client_name;
    }

    public String getClient_name(){
        return client_name;
    }

    public void setClient_type(int client_type){
        this.client_type=client_type;
    }

    public int getClient_type(){
        return client_type;
    }

    public void setLegal_repre(String legal_repre){
        this.legal_repre=legal_repre;
    }

    public String getLegal_repre(){
        return legal_repre;
    }

    public void setBusiness_license(String business_license){
        this.business_license=business_license;
    }

    public String getBusiness_license(){
        return business_license;
    }

    public void setSex(int sex){
        this.sex=sex;
    }

    public int getSex(){
        return sex;
    }

    public void setCard_type(int card_type){
        this.card_type=card_type;
    }

    public int getCard_type(){
        return card_type;
    }

    public void setCard_number(String card_number){
        this.card_number=card_number;
    }

    public String getCard_number(){
        return card_number;
    }

    public void setProfession(String profession){
        this.profession=profession;
    }

    public String getProfession(){
        return profession;
    }

    public void setFk_follow_stage(String fk_follow_stage){
        this.fk_follow_stage=fk_follow_stage;
    }

    public String getFk_follow_stage(){
        return fk_follow_stage;
    }

    public void setMobile_tele(String mobile_tele){
        this.mobile_tele=mobile_tele;
    }

    public String getMobile_tele(){
        return mobile_tele;
    }

    public void setHomephone(String homephone){
        this.homephone=homephone;
    }

    public String getHomephone(){
        return homephone;
    }

    public void setWork_phone(String work_phone){
        this.work_phone=work_phone;
    }

    public String getWork_phone(){
        return work_phone;
    }

    public void setFax(String fax){
        this.fax=fax;
    }

    public String getFax(){
        return fax;
    }

    public void setFk_annual_salary(String fk_annual_salary){
        this.fk_annual_salary=fk_annual_salary;
    }

    public String getFk_annual_salary(){
        return fk_annual_salary;
    }

    public void setBirthday(String birthday){
        this.birthday=birthday;
    }

    public String getBirthday(){
        return birthday;
    }

    public void setNationality(String nationality){
        this.nationality=nationality;
    }

    public String getNationality(){
        return nationality;
    }

    public void setNative_place(String native_place){
        this.native_place=native_place;
    }

    public String getNative_place(){
        return native_place;
    }

    public void setAddress(String address){
        this.address=address;
    }

    public String getAddress(){
        return address;
    }

    public void setFk_marriage(String fk_marriage){
        this.fk_marriage=fk_marriage;
    }

    public String getFk_marriage(){
        return fk_marriage;
    }

    public void setPostcard(String postcard){
        this.postcard=postcard;
    }

    public String getPostcard(){
        return postcard;
    }

    public void setResidential_zone(String residential_zone){
        this.residential_zone=residential_zone;
    }

    public String getResidential_zone(){
        return residential_zone;
    }

    public void setCreator_id(String creator_id){
        this.creator_id=creator_id;
    }

    public String getCreator_id(){
        return creator_id;
    }

    public void setCreator(String creator){
        this.creator=creator;
    }

    public String getCreator(){
        return creator;
    }

    public void setCreated_time(String created_time){
        this.created_time=created_time;
    }

    public String getCreated_time(){
        return created_time;
    }

    public void setModifier(String modifier){
        this.modifier=modifier;
    }

    public String getModifier(){
        return modifier;
    }

    public void setModified_time(String modified_time){
        this.modified_time=modified_time;
    }

    public String getModified_time(){
        return modified_time;
    }

    public void setIsdeleted(int isdeleted){
        this.isdeleted=isdeleted;
    }

    public int getIsdeleted(){
        return isdeleted;
    }

    public void setWorkplace(String workplace){
        this.workplace=workplace;
    }

    public String getWorkplace(){
        return workplace;
    }

    public void setContact(String contact){
        this.contact=contact;
    }

    public String getContact(){
        return contact;
    }

    public void setCorp_phone(String corp_phone){
        this.corp_phone=corp_phone;
    }

    public String getCorp_phone(){
        return corp_phone;
    }

    public void setCorp_area(String corp_area){
        this.corp_area=corp_area;
    }

    public String getCorp_area(){
        return corp_area;
    }

    public void setState(int state){
        this.state=state;
    }

    public int getState(){
        return state;
    }

    public void setFk_group_id(String fk_group_id){
        this.fk_group_id=fk_group_id;
    }

    public String getFk_group_id(){
        return fk_group_id;
    }

    public void setEmail(String email){
        this.email=email;
    }

    public String getEmail(){
        return email;
    }

    public void setFk_age(String fk_age){
        this.fk_age=fk_age;
    }

    public String getFk_age(){
        return fk_age;
    }

    public void setFk_use(String fk_use){
        this.fk_use=fk_use;
    }

    public String getFk_use(){
        return fk_use;
    }

}
