package com.zhiyou100.ssm.model;

import java.util.List;

public class RoleVO {
    private Role r;
    private List<Role> list;
    private String key;
    private String field;
    private int total;
    private int curuntpage;
    private int startpage;
    private int size;
    
	public int getStartpage() {
		return startpage;
	}
	public void setStartpage(int startpage) {
		this.startpage = startpage;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getCuruntpage() {
		return curuntpage;
	}
	public void setCuruntpage(int curuntpage) {
		this.curuntpage = curuntpage;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public Role getR() {
		return r;
	}
	public void setR(Role r) {
		this.r = r;
	}
	public List<Role> getList() {
		return list;
	}
	public void setList(List<Role> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "RoleVO [r=" + r + ", list=" + list + ", key=" + key + ", field=" + field + ", total=" + total
				+ ", curuntpage=" + curuntpage + ", startpage=" + startpage + ", size=" + size + "]";
	}
	
	
	
}
