package com.hhsales.zzxinteyu.hhsales.room_manage.bean;


import com.hhsales.zzxinteyu.hhsales.room_manage.annotation.TreeNodeId;
import com.hhsales.zzxinteyu.hhsales.room_manage.annotation.TreeNodeLabel;
import com.hhsales.zzxinteyu.hhsales.room_manage.annotation.TreeNodePid;
import com.hhsales.zzxinteyu.hhsales.room_manage.annotation.TreeNodeType;
import com.hhsales.zzxinteyu.hhsales.room_manage.annotation.TreeProjectId;

public class OrgBean
{
	@TreeNodeId
	private int _id;
	@TreeNodePid
	private int parentId;
	@TreeNodeLabel
	private String name;
    @TreeProjectId
	private String building_id;

    @TreeNodeType
	private int type;//0为项目 1为楼栋
	
//	public OrgBean(int _id, int parentId, String name)
//	{
//		this._id = _id;
//		this.parentId = parentId;
//		this.name = name;
//	}

	public OrgBean(int _id, int parentId, String name, String project_id) {
		this._id = _id;
		this.parentId = parentId;
		this.name = name;
		this.building_id = project_id;
	}

	public OrgBean(int _id, int parentId, String name, String building_id, int type) {
		this._id = _id;
		this.parentId = parentId;
		this.name = name;
		this.building_id = building_id;
		this.type = type;
	}

	public String getBuilding_id() {
		return building_id;
	}

	public void setBuilding_id(String building_id) {
		this.building_id = building_id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int get_id()
	{
		return _id;
	}

	public String getProject_id() {
		return building_id;
	}

	public void setProject_id(String project_id) {
		this.building_id = project_id;
	}

	public void set_id(int _id)
	{
		this._id = _id;
	}

	public int getParentId()
	{
		return parentId;
	}

	public void setParentId(int parentId)
	{
		this.parentId = parentId;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

}
