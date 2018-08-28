package com.pramod.controller;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pramod.DTO.CommentDTO;
import com.pramod.DTO.PostDTO;
import com.pramod.DTO.ReplyDTO;
//import com.pramod.DTO.PostDTO;
import com.pramod.DTO.UserDTO;
import com.pramod.entity.CommentEntity;
import com.pramod.entity.ReplyEntity;
import com.pramod.entity.UserEntity;
//import com.pramod.entity.PostEntity;
import com.pramod.manager.UserManager;
import com.pramod.templates.ResponseTemplate;
import com.pramod.uri.UserURI;

@RestController
public class UserController {

	@Autowired
	private UserManager usermanager;
	
	@GetMapping(UserURI.GET_ONE_USERS)
	public ResponseEntity<ResponseTemplate> getOneUser(@PathVariable Integer uid){
		
		//System.out.println(id);
		UserDTO oneuser =  usermanager.getOneUser(uid);
		System.out.println(oneuser);
		ResponseTemplate response = new ResponseTemplate();
		response.setCode(HttpStatus.OK.toString());
		response.setData(oneuser);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@GetMapping(UserURI.GET_ONE_USERS_POST)
	public ResponseEntity<ResponseTemplate> getUserPosts(@PathVariable Integer uid){
		List<PostDTO> posts = usermanager.getPosts(uid);
		ResponseTemplate response = new ResponseTemplate();
		response.setCode(HttpStatus.OK.toString());
		response.setData(posts);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@PostMapping(UserURI.GET_ONE_USERS_POST)
	public ResponseEntity<ResponseTemplate> setUserPosts(@RequestBody PostDTO post ,@PathVariable Integer uid){
		String postmessage = usermanager.setPosts(uid,post);
		ResponseTemplate response = new ResponseTemplate();
		response.setCode(HttpStatus.CREATED.toString());
		response.setData(postmessage);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@GetMapping(UserURI.GET_USERS)
	public ResponseEntity<ResponseTemplate> getUsers(){
		List<UserDTO> posts = usermanager.getUsers();
		ResponseTemplate response = new ResponseTemplate();
		response.setCode(HttpStatus.OK.toString());
		response.setData(posts);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@PostMapping(UserURI.GET_USERS)
	public ResponseEntity<ResponseTemplate> setUsers(@RequestBody UserDTO u){
		UserEntity message = usermanager.setUser(u);
		ResponseTemplate response = new ResponseTemplate();
		response.setCode(HttpStatus.OK.toString());
		response.setData(message);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@GetMapping(UserURI.GET_POST_COMMENT)
	public ResponseEntity<ResponseTemplate> getComment(@PathVariable Integer uid , @PathVariable Integer pid ){
		List<CommentEntity> c = usermanager.getPostComment(pid,uid);
		ResponseTemplate response = new ResponseTemplate();
		response.setCode(HttpStatus.OK.toString());
		response.setData(c);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@PostMapping(UserURI.GET_POST_COMMENT)
	public ResponseEntity<ResponseTemplate> save(@PathVariable Integer uid , @RequestBody CommentDTO commentDTO, @PathVariable Integer pid ){
		CommentEntity c = usermanager.saveComment(pid,uid,commentDTO);
		ResponseTemplate response = new ResponseTemplate();
		response.setCode(HttpStatus.OK.toString());
		response.setData(c);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@GetMapping(UserURI.GET_POST_COMMENT_REPLY)
	public ResponseEntity<ResponseTemplate> getReplies(@PathVariable Integer uid , @PathVariable Integer pid , @PathVariable Integer cid){
		System.out.println("uid : "+uid+" -- pid : "+pid+" -- cid : "+cid);
		List<ReplyEntity> c = usermanager.getPostCommentReplies(pid,uid,cid);	
		ResponseTemplate response = new ResponseTemplate();
		response.setCode(HttpStatus.OK.toString());
		response.setData(c);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@PostMapping(UserURI.GET_POST_COMMENT_REPLY)
	public ResponseEntity<ResponseTemplate> setReplies(@PathVariable Integer uid , @PathVariable Integer pid , @PathVariable Integer cid, @RequestBody ReplyDTO replyDTO){
		ReplyEntity c = usermanager.setPostCommentReplies(pid,uid,cid,replyDTO);
		ResponseTemplate response = new ResponseTemplate();
		response.setCode(HttpStatus.OK.toString());
		response.setData(c);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@PutMapping(UserURI.GET_USERS)
	public ResponseEntity<ResponseTemplate> updateuser(@RequestBody UserDTO user){
		
		UserEntity user1 = usermanager.saveUser(user);
		ResponseTemplate response = new ResponseTemplate();
		response.setCode(HttpStatus.OK.toString());
		response.setData(user1);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	
}
