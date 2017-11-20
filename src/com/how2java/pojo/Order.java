package com.how2java.pojo;

import java.util.List;

public class Order {
	private int id;
	private String code;
	List<Orderitem> orderitem;//一对多的时候需要这样
	

	@Override
	public String toString() {
		return "Order [id=" + id + ", code=" + code + ", orderitem=" + orderitem + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	


	public List<Orderitem> getOrderitem() {
		return orderitem;
	}

	public void setOrderitem(List<Orderitem> orderitem) {
		this.orderitem = orderitem;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	
}
