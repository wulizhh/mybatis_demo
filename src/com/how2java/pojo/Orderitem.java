package com.how2java.pojo;

public class Orderitem {

	private int id;
	private int number;
	private Order order;// 多对弈的时候需要这样
	private product product;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public product getProduct() {
		return product;
	}
	public void setProduct(product product) {
		this.product = product;
	}
	@Override
	public String toString() {
		return "Orderitem [id=" + id + ", number=" + number + ", order=" + order + ", product=" + product + "]";
	}
	

	
}
