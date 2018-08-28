package com.pramod.jpaconfig;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pramod.entity.PostEntity;

public interface PostJPA extends JpaRepository<PostEntity, Integer> {

}
