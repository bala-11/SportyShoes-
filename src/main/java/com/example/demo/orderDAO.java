package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class orderDAO {
	@Autowired
	orderRepo repo;

	public Orders insert(Orders o) {
		return repo.save(o);
		// TODO Auto-generated method stub
		
		
	}
	public List<Orders> listoforders(){
		return repo.findAll();
	}
	public List<Orders> findbyshoeid(int id){
		return  repo.findByShoeId(id);
	}

}
