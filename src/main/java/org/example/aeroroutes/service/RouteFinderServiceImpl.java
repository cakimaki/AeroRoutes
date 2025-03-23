package org.example.aeroroutes.service;

import org.example.aeroroutes.domain.Route;
import org.example.aeroroutes.graph.FlightNetwork;
import org.example.aeroroutes.repository.FlightRepository;

import java.util.List;
import java.util.Optional;

public class RouteFinderServiceImpl implements RouteFinderService{
	private final FlightNetwork flightNetwork;
	
	// Upon initialization create the graph (network) of flights.
	public RouteFinderServiceImpl(FlightRepository flightRepository){
		this.flightNetwork = new FlightNetwork(flightRepository.getAllFlights());
	}
	
	// Find all possible routes from origin to destination (optional maxFlights)
	@Override
	public List<Route> findRoutes(String origin, String destination, Optional<Integer> maxFlights) {
		// TODO
		//  Implement the most important part of the task. Graph traversal.
		return List.of();
	}
	
	private void findRoutesDFS(){
		//implement it
	}
}
