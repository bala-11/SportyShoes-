package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoeDAO {
@Autowired
ShoeRepo repo;

public Shoe insert(Shoe s) {
	return repo.save(s);
}
public List<Shoe> listofShoes(){
	return repo.findAll();
}
public List<Shoe> findbyshoename(int id){
	return (List<Shoe>) repo.findByShoeId(id);
}

public void delete(int id) {
	 repo.deleteById(id);
}

public Shoe updateByid(Shoe s) { 
	Shoe ss=repo.findById(s.getShoeid()).orElse(null);
   ss.setShoebrand(s.getShoebrand());
   ss.setColor(s.getColor());
   ss.setQuantity(s.getQuantity());
   ss.setCost(s.getCost());
    return repo.save(s);

}

}
