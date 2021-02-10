package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.extern.slf4j.Slf4j;

import com.example.demo.Order;


@Slf4j
@Controller
@RequestMapping("/orders") // specifies that any request to this url will be handled here
public class OrderController {
	
	@GetMapping("/current") // any get requests sent to /orders/current will be handled here
	public String orderForm(Model model) {
		model.addAttribute("order",new Order()); //the instance of order will be exposed to orderForm view template
		return "orderForm";
	}
	
	@PostMapping
	public String processOrder(Order order) {
		System.out.println("Order submitted---> " + order);
		return "redirect:/";
	}
	

}
