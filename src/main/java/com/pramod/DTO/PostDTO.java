package com.pramod.DTO;


import java.sql.Date;
import lombok.Data;
@Data
public class PostDTO {

private Integer pid;
	
	private String title;
	
	private Date timestamp;
	
	private Integer likes;

	//private List<CommentDTO> comments;
}
