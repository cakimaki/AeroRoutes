package org.example.aeroroutes.service;

import org.example.aeroroutes.domain.Flight;
import org.example.aeroroutes.domain.Route;
import org.example.aeroroutes.graph.FlightNetwork;
import org.example.aeroroutes.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RouteFinderServiceImpl implements RouteFinderService{
	private final FlightNetwork flightNetwork;
	
	// Upon initialization create the graph (network) of flights.
	public RouteFinderServiceImpl(FlightRepository flightRepository){
		this.flightNetwork = new FlightNetwork(flightRepository.getAllFlights());
	}
	
	// Find all possible routes from origin to destination (optional maxFlights)
	@Override
	public List<Route> findRoutes(String origin, String destination, Optional<Integer> maxFlights) {
		List<Route> routesResult = new ArrayList<>();
		findRoutesDFS(origin, destination, maxFlights, new ArrayList<>(), routesResult);
		return routesResult;
	}
	
	private void findRoutesDFS(String current, String destination, Optional<Integer> maxFlights,
	                           List<Flight> currentPath, List<Route> routesResult){
		// base case - reached destination.
		if(destination.equals(current)){
			routesResult.add(new Route(new ArrayList<>(currentPath)));
			return;
		}
		
		if(maxFlights.isPresent() && maxFlights.get() <= currentPath.size()){
			return;
		}
		
		for(Flight flight : flightNetwork.getFlightsFrom(current)){
			currentPath.add(flight);
			findRoutesDFS(flight.getDestination(), destination, maxFlights, currentPath, routesResult);
			currentPath.removeLast();
		}
	}
}
