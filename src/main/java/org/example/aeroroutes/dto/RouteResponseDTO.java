package org.example.aeroroutes.dto;

import java.util.List;

public class RouteResponseDTO {
	private List<String> cities;
	private Integer price;
	
	public RouteResponseDTO(List<String> cities, Integer price){
		this.cities = cities;
		this.price = price;
	}
	
	public void setCities(List<String> cities) {
		this.cities = cities;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public List<String> getCities(){
		return cities;
	}
	public Integer getPrice(){
		return price;
	}
	
}
