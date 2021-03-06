package com.san.entity1;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Laptop {
@Id
private int id;
private int price;
private String name;
public Laptop(int id, int price, String name) {
	super();
	this.id = id;
	this.price = price;
	this.name = name;
}
public Laptop() {
	super();
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
@Override
public String toString() {
	return "Laptop [id=" + id + ", price=" + price + ", name=" + name + "]";
}

}

