package com.szl.springioc.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Collections {
	
	private boolean flag;
	
	private Map<String, Object> mapParams;
	
	private List<String> listParmas;
	
	private Set<String> setParams;

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public Map<String, Object> getMapParams() {
		return mapParams;
	}

	public void setMapParams(Map<String, Object> mapParams) {
		this.mapParams = mapParams;
	}

	public List<String> getListParmas() {
		return listParmas;
	}

	public void setListParmas(List<String> listParmas) {
		this.listParmas = listParmas;
	}

	public Set<String> getSetParams() {
		return setParams;
	}

	public void setSetParams(Set<String> setParams) {
		this.setParams = setParams;
	}

	@Override
	public String toString() {
		return "Collections [flag=" + flag + ", mapParams=" + mapParams + ", listParmas=" + listParmas + ", setParams="
				+ setParams + "]";
	}
	
	

}
