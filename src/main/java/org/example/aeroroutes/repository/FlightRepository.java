package org.example.aeroroutes.repository;

import org.example.aeroroutes.domain.Flight;

import java.util.List;

public interface FlightRepository {
	List<Flight> getAllFlights();
	List<Flight> getFlightsFrom(String origin);
}
