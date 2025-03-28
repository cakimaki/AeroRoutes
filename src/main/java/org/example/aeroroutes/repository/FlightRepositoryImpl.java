package org.example.aeroroutes.repository;

import org.example.aeroroutes.domain.Flight;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class FlightRepositoryImpl implements FlightRepository {
	private final List<Flight> flights;
	
	public FlightRepositoryImpl() {
		this.flights = new ArrayList<>();
		loadFlights();
	}
	
	@Override
	public List<Flight> getAllFlights() {
		return flights;
	}
	
	@Override
	public List<Flight> getFlightsFrom(String origin) {
		return flights.stream()
				.filter(flight -> flight.getOrigin().equalsIgnoreCase(origin))
				.collect(Collectors.toCollection(ArrayList::new));
	}
	
	private void loadFlights() {
		InputStream inputStream = getClass().getResourceAsStream("/flights.txt");
		if (inputStream == null) {
			throw new RuntimeException("flights.txt not found in resources");
		}
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));) {
			String line;
			
			while ((line = br.readLine()) != null) {
				String[] parts = line.split(",");
				
				// Check if line has 3 parts - origin,dest,price
				//if it doesnt have print error and continue.
				if (parts.length != 3) {
					System.err.println("Skipping incorrect line (as the format is incorrect) " + line);
					continue;
				}
				
				//assign the flights to the Flight object and add it to the List
				try {
					String origin = parts[0].trim();
					String destination = parts[1].trim();
					int price = Integer.parseInt(parts[2].trim());
					flights.add(new Flight(origin, destination, price));
				} catch (NumberFormatException e) {
					System.err.println("Skipping line due to invalid price: " + line);
				}
				
			}
		} catch (
				IOException e) {
			e.printStackTrace();
		}
	}
}
