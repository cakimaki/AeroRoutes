package org.example.aeroroutes.repository;

import org.example.aeroroutes.domain.Flight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlightRepositoryImpl implements FlightRepository{
	private List<Flight> flights;
	
	public FlightRepositoryImpl(){
		this.flights = new ArrayList<>();
		loadFlights();
	}
	
	private void loadFlights(){
		InputStream inputStream = getClass().getResourceAsStream("/flights.txt");
		if(inputStream == null){
			throw new RuntimeException("flights.txt not found in resources");
		}
		
		try(BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));){
			String line;
			
			while((line = br.readLine()) != null){
				String[] parts = line.split(",");
				
				// Check if line has 3 parts - origin,dest,price (edge-case)
				if(parts.length == 3){
					String origin = parts[0].trim();
					String destination = parts[1].trim();
					int price = Integer.parseInt(parts[2].trim());
					flights.add(new Flight(origin,destination,price));
				}
				//todo
				// check if price is valid to be parsed.

			}
		}catch(IOException e){
			e.printStackTrace();
		}
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
}
