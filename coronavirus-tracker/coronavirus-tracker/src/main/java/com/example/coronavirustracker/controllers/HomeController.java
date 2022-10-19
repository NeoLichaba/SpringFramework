package com.example.coronavirustracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.coronavirustracker.models.LocationStats;
import com.example.coronavirustracker.services.CoronaVirusDataService;

@Controller	//renders UI 
public class HomeController {
	
	@Autowired
	CoronaVirusDataService coronaVirusDataService; 
	
	@GetMapping("/") //root template	
	public String home(Model model) {
		List <LocationStats> allStats = coronaVirusDataService.getAllStats();
		int totalReportedCases = allStats.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
		int totalNewCases = allStats.stream().mapToInt(stat -> stat.getDiffFromPrevDay()).sum();
		model.addAttribute("locationStats", allStats);
		model.addAttribute("totalReportedCases", totalReportedCases);
		model.addAttribute("totalNewCases", totalNewCases);
		return "home"; //returns what's in the home.html file
	}
 
}
