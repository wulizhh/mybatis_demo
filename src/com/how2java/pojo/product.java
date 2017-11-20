package com.how2java.pojo;

public class product {
private int pid;
private String name;
private int price;
//private Category category;
/*
public Category getCategory() {
	return category;
}
public void setCategory(Category category) {
	this.category = category;
}*/
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
@Override
public String toString() {
	return "product [pid=" + pid + ", name=" + name + ", price=" + price + "]";
}

}
