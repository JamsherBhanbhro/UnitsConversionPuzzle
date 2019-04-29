package com.ansur.main;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Unit {

	private String name;
	private int order;
	Map<String, Integer> cFactMap = new ConcurrentHashMap<String, Integer>();

	public Map<String, Integer> getcFactMap() {
		return cFactMap;
	}

	public void setcFactMap(Map<String, Integer> cFactMap) {
		this.cFactMap = cFactMap;
	}

	public Unit(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

}
