package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<Users, Integer>{

	@Query("select u from Users u where u.username=?1")
	public Users findByName(String name);
	
	@Query("select u from Users u where u.password=?1")
	public Users findBypassword(String name);

}
