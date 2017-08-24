package com.formation.wiki.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private Integer idRole;
	@Column(name="NAME")
	private String name;
	@Column(name="DESCRIPTION")
	private String description;
	
	

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return idRole;
	}

	public void setId(Integer id) {
		this.idRole = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
