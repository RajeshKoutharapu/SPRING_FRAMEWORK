package com.SpringSecurity.MulUserswithDataBase.Dao;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class user {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
    private String name;
    private String pass;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public user(Integer id, String name, String pass) {
		super();
		this.id = id;
		this.name = name;
		this.pass = pass;
	}
	public user() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	
	
}
