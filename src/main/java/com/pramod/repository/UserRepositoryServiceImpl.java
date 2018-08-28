package com.pramod.repository;

import java.util.List;

import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import com.pramod.entity.CommentEntity;
import com.pramod.entity.PostEntity;
import com.pramod.entity.ReplyEntity;
import com.pramod.entity.UserEntity;


public class UserRepositoryServiceImpl extends QueryDslRepositorySupport implements UserRepositoryService    {


	public UserRepositoryServiceImpl(Class<?> domainClass) {
		super(domainClass);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<UserEntity> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserEntity getUser(Integer uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostEntity> getPosts(Integer uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CommentEntity> getComments(Integer pid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReplyEntity> getReplies(Integer cid) {
		// TODO Auto-generated method stub
		return null;
	}

}
