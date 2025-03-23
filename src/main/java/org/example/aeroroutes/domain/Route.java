package org.example.aeroroutes.domain;

import java.util.ArrayList;
import java.util.List;

public class Route {
	private List<Flight> flights;
	
	public Route(){
		flights = new ArrayList<>();
	}
	
	public Route(List<Flight> flights){
		this.flights = flights;
	}
	
	
	public List<Flight> getFlights(){
		return flights;
	}
	
	public void setFlights(List<Flight> flights){
		this.flights = flights;
	}
	
	public Flight addFlight(Flight flight){
		if(flight!=null){
			flights.add(flight);
		}
		return flight;
	}
	@Override
	public String toString(){
		return "Route = " +
				"[flights=" + flights + "]";
	}
}
