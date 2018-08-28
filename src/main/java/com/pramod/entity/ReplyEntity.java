package com.pramod.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

//import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name="reply")
public class ReplyEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 12345;
	
	@Id
	@GeneratedValue
	private Integer rid;
	
	private String reply;
	
	private Date date;

	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private CommentEntity cid;
	
}
