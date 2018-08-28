package com.pramod.jpaconfig;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pramod.entity.CommentEntity;
//import com.pramod.entity.ReplyEntity;

public interface CommentJPA extends JpaRepository<CommentEntity, Integer> {

}
