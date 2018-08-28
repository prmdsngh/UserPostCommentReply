package com.pramod.repository;

import java.util.List;

import com.pramod.entity.CommentEntity;
import com.pramod.entity.PostEntity;
import com.pramod.entity.ReplyEntity;
import com.pramod.entity.UserEntity;

public interface UserRepositoryService {

	public List<UserEntity> getUsers(); 
	public UserEntity getUser(Integer uid);
	public List<PostEntity> getPosts(Integer uid);
	public List<CommentEntity> getComments(Integer pid);
	public List<ReplyEntity> getReplies(Integer cid);
}
