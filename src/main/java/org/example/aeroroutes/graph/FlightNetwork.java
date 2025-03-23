package org.example.aeroroutes.graph;

import org.example.aeroroutes.domain.Flight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlightNetwork {
	private Map<String, List<Flight>> graph;
	
	public FlightNetwork(List<Flight> flights){
		this.graph = new HashMap<>();
		buildGraph(flights);
	}
	
	private void buildGraph(List<Flight> flights) {
		for(Flight flight : flights){
			graph.computeIfAbsent(flight.getOrigin(), k -> new ArrayList<>()).add(flight);
		}
	}
	
	public List<Flight> getFlightsFrom(String origin){
		return graph.getOrDefault(origin, new ArrayList<>());
	}
}