package com.example.coronavirustracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller	//renders UI 
public class HomeController {
	
	@GetMapping("/") //root template	
	public String home() {
		//model.addAttribute("testName", "TEST");
		return "home"; //returns what's in the home.html file
	}
 
}
