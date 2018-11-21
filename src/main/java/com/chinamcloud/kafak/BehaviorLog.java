package com.chinamcloud.kafak;

import java.io.Serializable;

public class BehaviorLog implements Serializable{

	private static final long serialVersionUID = 3586342132445383128L;
	private String action;
	private String user_id;
	private String act_obj;
	private String bhv_type;
	private String use_duration;
	private String bhv_datetime;
	private String tenant;
	
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getAct_obj() {
		return act_obj;
	}
	public void setAct_obj(String act_obj) {
		this.act_obj = act_obj;
	}
	public String getBhv_type() {
		return bhv_type;
	}
	public void setBhv_type(String bhv_type) {
		this.bhv_type = bhv_type;
	}
	public String getUse_duration() {
		return use_duration;
	}
	public void setUse_duration(String use_duration) {
		this.use_duration = use_duration;
	}
	public String getBhv_datetime() {
		return bhv_datetime;
	}
	public void setBhv_datetime(String bhv_datetime) {
		this.bhv_datetime = bhv_datetime;
	}
	public String getTenant() {
		return tenant;
	}
	public void setTenant(String tenant) {
		this.tenant = tenant;
	}
	
}
