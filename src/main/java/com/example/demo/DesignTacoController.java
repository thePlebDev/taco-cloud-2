package com.example.demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Ingredient.Type;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {
	
	@GetMapping
	public String showDesignForm(Model model) {
		List<Ingredient> ingredients = Arrays.asList( // creates a hard coded list of ingredient objects
				new Ingredient("FLTO","Flour Tortilla",Type.WRAP),
				new Ingredient("COTO","Corn Tortilla",Type.WRAP),
				new Ingredient("GRBF","Ground Beef",Type.PROTEIN),
				new Ingredient("CARN","Carnitas",Type.PROTEIN),
				new Ingredient("TMTO","Diced Tomatoes",Type.VEGGIES),
				new Ingredient("LETC","Lettuce",Type.VEGGIES),
				new Ingredient("CHED","Cheddar",Type.CHEESE),
				new Ingredient("JACK","Monterrey Jack",Type.CHEESE),
				new Ingredient("SLSA","Salsa",Type.SAUCE),
				new Ingredient("SRCR","Sour Cream",Type.SAUCE)
				
				);
			Type[] types = Ingredient.Type.values(); // an array of all the types 
			for (Type type : types) {
				//filters the list by ingredient type
				// list of ingredient types is exposed to the view 
				model.addAttribute(type.toString().toLowerCase(),filterByType(ingredients,type)); // list of ingredient types exposed to view
			}
			model.addAttribute("design", new Taco()); // object exposed to view with keyword design
			
			return "design";
	}
	
	private List<Ingredient> filterByType(List<Ingredient> ingredients,Type type){
		return ingredients.stream()
				.filter(x->x.getType().equals(type))
				.collect(Collectors.toList());
	}
	
	@PostMapping // this means that it will handle any post requests to the design endpoint 
	public String processDesign(Taco design) {
		// saving objects and stuff will enventually go here
		System.out.println("Design ---> " + design);
		
		return "redirect:/orders/current";
	}
	
}
