package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
@Entity
@Data
public class Shoe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int shoeid;
	private String shoebrand;
	private String color;
	private int quantity;
	private int cost;
}
