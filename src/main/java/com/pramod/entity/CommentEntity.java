package com.pramod.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name="comment")
@Data
public class CommentEntity {

	@Id
	@GeneratedValue
	private Integer cid;
	
	private Date timestamp;
	
	private String description;
	
	private Integer likes;

	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private PostEntity pid;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy = "cid")
	private List<ReplyEntity> replies;
	
	
	
	
}
