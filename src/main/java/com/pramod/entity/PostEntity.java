package com.pramod.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

//import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name="post")
@Data
public class PostEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 12345;
	
	@Id
	@GeneratedValue
	@Column(name="pid")
	private Integer pid;
	
	private String title;
	
	private Date timestamp;
	
	private Integer likes;

	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private UserEntity uid;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy = "pid")
	private List<CommentEntity> comments;
	

}
