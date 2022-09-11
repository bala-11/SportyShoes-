package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDAO {
	@Autowired
	UserRepo repo;
	
	public Users userSignup(Users u) {
		return repo.save(u);
	}
	public List<Users> listofall() {
		return repo.findAll();
	}
	public void delete(int id) {
	 repo.deleteById(id);
}
	public Users updateByid(Users s) { 
	Users ss=repo.findById(s.getUserid()).orElse(null);
  ss.setUsername(s.getUsername());
  ss.setPassword(s.getPassword());
  ss.setEmail(s.getEmail());
  ss.setAddress(s.getAddress());
  ss.setPhno(s.getPhno());
   return repo.save(s);

}
}
