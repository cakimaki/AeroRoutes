package org.example.aeroroutes;

import org.example.aeroroutes.repository.FlightRepository;
import org.example.aeroroutes.repository.FlightRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AeroRoutesApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(AeroRoutesApplication.class, args);
		
		//testing flightrepository if loading from file works.
//		FlightRepository flightRepository = new FlightRepositoryImpl();
//
//		System.out.println("All flights:");
//		flightRepository.getAllFlights().forEach(System.out::println);
//
//		System.out.println("\nFlights from SOF:");
//		flightRepository.getFlightsFrom("SOF").forEach(System.out::println);
//		System.out.println("?");
		
	
	}
	
}
