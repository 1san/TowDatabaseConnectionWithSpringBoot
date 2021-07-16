package com.san.entity2;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
@Id
private int id;
private String name;
public Customer(int id, String name) {
	super();
	this.id = id;
	this.name = name;
}
public Customer() {
	super();
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
@Override
public String toString() {
	return "Customer [id=" + id + ", name=" + name + "]";
}

}
