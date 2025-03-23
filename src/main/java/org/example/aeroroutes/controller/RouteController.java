package org.example.aeroroutes.controller;

import org.example.aeroroutes.dto.RouteRequestDTO;
import org.example.aeroroutes.dto.RouteResponseDTO;
import org.example.aeroroutes.service.RouteFinderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/routes")
public class RouteController {
	private final RouteFinderService routeFinderService;
	
	public RouteController(RouteFinderService routeFinderService){
		this.routeFinderService = routeFinderService;
	}
	
	@PostMapping
	public RouteResponseDTO findRoutes(@RequestBody RouteRequestDTO requestDTO){
		
		return null;
	}
}
