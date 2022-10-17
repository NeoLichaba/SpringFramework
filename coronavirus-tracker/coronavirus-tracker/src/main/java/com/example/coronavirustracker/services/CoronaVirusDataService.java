package com.example.coronavirustracker.services;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.coronavirustracker.models.LocationStats;

//Class reads data from CoronaVirus file

@Service
public class CoronaVirusDataService {
	
	
	//Call data from CSV file, using URL

	private static String VIRUS_DATA_URL= "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";
	
	//instance of location stats created
	
	private List<LocationStats> allStats = new ArrayList<>();
	
	@PostConstruct //execute method
	@Scheduled(cron = "* * 1 * * *") //cron expression runs method every day using proxy
	public void fetchVirusData() throws IOException, InterruptedException {
		
		//Allows for user to obtain current information
		List<LocationStats> newStats = new ArrayList<>();
		
		//HTTP calls - using HTTP client
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
		.uri(URI.create(VIRUS_DATA_URL)) 
		.build();
		
		//obtain response by sending client request
		//body taken and returned as a string
		HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
		
		//Creating StringReader
		StringReader csvBodyReader = new StringReader(httpResponse.body());
		
		//Header Auto Detection
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvBodyReader);
		for (CSVRecord record : records) {			
			LocationStats locationStat = new LocationStats();
			locationStat.setState(record.get("Province/State"));
			locationStat.setCountry(record.get("Country/Region"));			
			locationStat.setLatestTotalCases(Integer.parseInt(record.get(record.size()-1)));		   
		    System.out.println(locationStat);
		    newStats.add(locationStat);
		    
		}
		
		//concurrency proofing
		this.allStats = newStats;
	}

}
