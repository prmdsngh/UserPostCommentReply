package com.pramod.DTO;

import java.sql.Date;

//import com.pramod.entity.CommentEntity;

import lombok.Data;

@Data
public class ReplyDTO {

	private Integer rid;
	
	private String reply;
	
	private Date date;
}
