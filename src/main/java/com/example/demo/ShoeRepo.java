package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ShoeRepo extends JpaRepository<Shoe, Integer>{
	@Query("select u from Shoe u where u.shoeid=?1")
	public List<Shoe> findByShoeId(int id);

}
