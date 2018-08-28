package com.pramod.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="user")
@Data
public class UserEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 123456;
	
	@Id
	@GeneratedValue
	@Column(name="uid")
	private Integer uid;
	
	@Column(name="age")
	private Integer age;
	
	@Column(name="college")
	private String college;
	
	@Column(name="email")
	private String email;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy = "uid")
	private List<PostEntity> posts;
	
	}
