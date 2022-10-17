package com.example.spring;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

//Class reads data from Corona Virus file

@Service
public class CoronaVirusDataService {
	
	
	//Call data from CSV file, using URL

	private static String VIRUS_DATA_URL= "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";
	
	@PostConstruct //execute method
	public void fetchVirusData() throws IOException, InterruptedException {
		
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

		Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(csvBodyReader);
		for (CSVRecord record : records) {
		    String state = record.get("Province/State");
		    System.out.println(state);
		    
		}
	}

}
