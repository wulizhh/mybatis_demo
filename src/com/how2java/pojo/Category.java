package com.how2java.pojo;

import java.util.List;

public class Category {
	private int id;

	private String name;
	List<product> list;

	public List<product> getList() {
		return list;
	}

	public void setList(List<product> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", list=" + list + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
