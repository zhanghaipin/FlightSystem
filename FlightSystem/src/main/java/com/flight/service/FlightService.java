package com.flight.service;

import java.util.List;

import com.flight.bean.Flight;
import com.flight.bean.TransFlight;

public interface FlightService {

	public List<Flight> getFlights(String dCity,String aCity,String date);
	
	public List<TransFlight> getTransFlights(String dCity,String aCity,String date);
}
