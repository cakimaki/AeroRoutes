package org.example.aeroroutes.service;

import org.example.aeroroutes.domain.Route;

import java.util.List;
import java.util.Optional;


public interface RouteFinderService{
	List<Route> findRoutes(String origin, String destination, Optional<Integer> maxFlights);
}
