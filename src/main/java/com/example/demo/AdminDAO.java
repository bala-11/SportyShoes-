package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminDAO {
	
	@Autowired
	AdminRepo repo;
	
	public Admin update(Admin a) {
		
		Admin an=repo.findById(a.getId()).orElse(null);
		an.setPassword(a.getPassword());
		return repo.save(an);
		
	}


}
