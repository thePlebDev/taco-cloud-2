package com.example.demo;

import java.util.List;
import java.util.Date;

import lombok.Data;



@Data
public class Taco {
	
	private Long id;
	private Date createdAt;
	
	private String name;
	private List<String> ingredients;

}
