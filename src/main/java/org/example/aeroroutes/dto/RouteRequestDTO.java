package org.example.aeroroutes.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class RouteRequestDTO {
	//Notblank ensures it is not null, not "", not " " or "/n"
	@NotBlank
	private String origin;
	@NotBlank
	private String destination;
	// Integer is common for the JSON (unlike the Optional<Integer>)
	// will be parsed in the request later.
	private Integer maxFlights = null;
	
	public RouteRequestDTO(String origin, String destination, Integer maxFlights){
		this.origin = origin;
		this.destination = destination;
		this.maxFlights = maxFlights;
	}
	
	public String getOrigin(){
		return origin;
	}
	
	public String getDestination(){
		return destination;
	}
	
	public Integer getMaxFlights(){
		return maxFlights;
	}
	
	public void setOrigin(String origin){
		this.origin = origin;
	}
	public void setDestination(String destination){
		this.destination = destination;
	}
	public void setMaxFlights(Integer maxFlights){
		this.maxFlights = maxFlights;
	}
}
