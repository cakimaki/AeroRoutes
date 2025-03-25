package org.example.aeroroutes.controller;

import jakarta.validation.Valid;
import org.example.aeroroutes.domain.Route;
import org.example.aeroroutes.dto.RouteRequestDTO;
import org.example.aeroroutes.dto.RouteResponseDTO;
import org.example.aeroroutes.service.RouteFinderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/routes")
public class RouteController {
	private final RouteFinderService routeFinderService;
	
	public RouteController(RouteFinderService routeFinderService) {
		this.routeFinderService = routeFinderService;
	}
	
	@PostMapping
	public ResponseEntity<List<RouteResponseDTO>> findRoutes(@RequestBody @Valid RouteRequestDTO request) {
		try {
			List<Route> routes = routeFinderService.findRoutes(
					request.getOrigin(),
					request.getDestination(),
					Optional.ofNullable(request.getMaxFlights())
			);
			List<RouteResponseDTO> response = routes.stream()
					.map(route -> new RouteResponseDTO(route.getCities(),route.getPrice()))
					.collect(Collectors.toCollection(ArrayList::new));
			
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
