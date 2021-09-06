package com.example.FlyAway.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.FlyAway.model.Admin;

public interface AdminDao extends CrudRepository<Admin, Integer> {

	@Query(nativeQuery = true, value = "select * from admin u where u.username like :username and u.password like :password")
	Admin findByUsernameAndPassword(String username, String password);

}
