package com.example.coronavirustracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller	
public class HomeController {
	
	@GetMapping("/") //root template	
	public String home() {
		return "home"; //returns what's in the home.html file
	}

}
