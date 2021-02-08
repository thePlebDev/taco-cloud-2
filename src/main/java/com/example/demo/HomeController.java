package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //automatically registered as spring bean
public class HomeController {
	
	@GetMapping
	public String home() {
		return "home";
	}

}
