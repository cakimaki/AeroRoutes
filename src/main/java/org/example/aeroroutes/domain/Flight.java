package org.example.aeroroutes.domain;

public class Flight {
	private String origin;
	private String destination;
	private int price;
	
	public Flight() {
	
	}
	
	public Flight(String origin, String destination, int price){
		this.origin = origin;
		this.destination = destination;
		this.price = price;
	}
	
	public String getOrigin(){
		return this.origin;
	}
	public String getDestination(){
		return this.destination;
	}
	public int getPrice(){
		return this.price;
	}
	
	public void setOrigin(String origin){
		this.origin=origin;
	}
	public void setDestination(String destination){
		this.destination = destination;
	}
	public void setPrice(int price){
		this.price = price;
	}
	
	@Override
	public String toString(){
		return "Flight = " +
				"[origin=" + origin +
				" destination=" + destination +
				" price=" + price +
				"]";
	}
	
}
