package com.pramod.DTO;

import java.sql.Date;
import lombok.Data;

@Data
public class CommentDTO {

private Integer cid;
	
	private Date timestamp;
	
	private String description;
	
	private Integer likes;
}
