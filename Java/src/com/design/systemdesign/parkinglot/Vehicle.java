package com.design.systemdesign.parkinglot;

public class Vehicle {
	
	private String vehicleNumber;
	private String color;
	private final VehicleType type;
	
	public Vehicle(String vehicleNumber, String color, VehicleType type)
	{
		this.type = type;
		this.vehicleNumber= vehicleNumber;
		this.color =color;
	}
	
	public String getVehicleNumber()
	{
		return this.vehicleNumber;
	
	}
	
	public String getColor()
	{
		return this.color;
		
	}
	public void setVehicleNumber(String vehicleNumber)
	{
		this.vehicleNumber =vehicleNumber;
		
	}
	public void setColort(String color)
	{
		this.color =color;
	}
	

}
