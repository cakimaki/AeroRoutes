package org.example.aeroroutes;

import org.example.aeroroutes.domain.Flight;
import org.example.aeroroutes.repository.FlightRepository;
import org.example.aeroroutes.repository.FlightRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

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
		
		
		FlightRepository repository = new FlightRepositoryImpl();
		List<Flight> flights = repository.getAllFlights();
		System.out.println("Loaded flights:");
		flights.forEach(flight -> System.out.println(
				"Origin: " + flight.getOrigin() +
						", Destination: " + flight.getDestination() +
						", Price: " + flight.getPrice()));
	
	}
	
}
