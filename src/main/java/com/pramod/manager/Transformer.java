package com.pramod.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pramod.DTO.CommentDTO;
import com.pramod.DTO.PostDTO;
import com.pramod.DTO.ReplyDTO;
import com.pramod.DTO.UserDTO;
import com.pramod.entity.CommentEntity;
import com.pramod.entity.PostEntity;
import com.pramod.entity.ReplyEntity;
import com.pramod.entity.UserEntity;

//import infinispan.com.mchange.v2.beans.BeansUtils;

//import infinispan.com.mchange.v2.beans.BeansUtils;

public class Transformer {

	public static UserDTO getUserDTO(UserEntity u) {
		UserDTO userDTO = new UserDTO();
		BeanUtils.copyProperties(u, userDTO);
		return userDTO;
	}
	
	public static List<UserDTO> getUsers(List<UserEntity> userList ){
		
		List<UserDTO> userDTO = new ArrayList<>();
		
		for(UserEntity post : userList) {
			UserDTO u = new UserDTO();
			BeanUtils.copyProperties(post, u);
			userDTO.add(u);	
		}
		System.out.println(userDTO);
		return userDTO;
	}
	
	public static List<PostDTO> getUserPosts(List<PostEntity> userpost ){
		
		List<PostDTO> postDTO = new ArrayList<>();
		
		for(PostEntity post : userpost) {
			PostDTO u = new PostDTO();
			BeanUtils.copyProperties(post, u);
			postDTO.add(u);
			
		}
		return postDTO;
	}

	public static PostEntity getPostEntity(PostDTO post) {
		// TODO Auto-generated method stub
		PostEntity posts = new PostEntity();
		BeanUtils.copyProperties(post, posts);
		return posts;
	}

	public static List<PostDTO> getPostDTO(List<PostEntity> posts) {
		// TODO Auto-generated method stub
		List<PostDTO> postDTO = new ArrayList<>();
		for(PostEntity p : posts) {
			PostDTO o = new PostDTO();
			BeanUtils.copyProperties(p, o);
			postDTO.add(o);
		}
		return postDTO;
	}

	public static CommentEntity getCommentEntity(CommentDTO commentDTO) {
		// TODO Auto-generated method stub
		CommentEntity comment = new CommentEntity();
		BeanUtils.copyProperties(commentDTO, comment);
		return comment;
	}

	public static ReplyEntity getReplyEntity(ReplyDTO replyDTO) {
		// TODO Auto-generated method stub
		ReplyEntity reply = new ReplyEntity();
		BeanUtils.copyProperties(replyDTO, reply);
		return reply;
	}

	public static UserEntity getUserEntity(UserDTO user) {
		// TODO Auto-generated method stub
		UserEntity users = new UserEntity();
		BeanUtils.copyProperties(user, users);
		return users;
	}
	
	
	
}
