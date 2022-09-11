package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface orderRepo extends JpaRepository<Orders, Integer>{
	@Query("select u from Orders u where u.shoeid=?1")
	public List<Orders> findByShoeId(int id);


}
