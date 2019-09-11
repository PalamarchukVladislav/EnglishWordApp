package com.luv2code.springboot.cruddemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Category {

	// define fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="category")
	private String category;

		
	// define constructors
	
	public Category() {
		
	}

	public Category(String category, String lastName, String email) {
		this.category = category;

	}

	// define getter/setter
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}


	// define tostring

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + category + ", lastName=" + ", email=" + "]";
	}
		
}











