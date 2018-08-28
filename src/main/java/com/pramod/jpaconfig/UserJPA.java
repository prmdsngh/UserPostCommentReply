package com.pramod.jpaconfig;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pramod.entity.UserEntity;

@Repository
public interface UserJPA extends CrudRepository<UserEntity, Integer> {

}
