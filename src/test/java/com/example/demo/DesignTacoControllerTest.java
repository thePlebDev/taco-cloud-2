package com.example.demo;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class) // boiler code to get the test to run in the right context
@WebMvcTest(DesignTacoController.class) // runs the single controller 
public class DesignTacoControllerTest {
	// don't have to test ingredient because lombok is taking care of it 
	
	@Autowired // for the dependency injection
	private MockMvc mockMvc;
	
	@Test
	public void testDesignPage() throws Exception{
		mockMvc.perform(get("/design"))
			.andExpect(status().isOk())
			.andExpect(view().name("design"));
	}
	

}
