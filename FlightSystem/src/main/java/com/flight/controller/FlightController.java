package com.flight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flight.bean.Flight;
import com.flight.bean.TransFlight;
import com.flight.service.FlightService;

/*
 * 航班controller
 */
@Controller
public class FlightController {

	@Autowired
	private FlightService flightService;
	
	@RequestMapping(value="/flight")
	@ResponseBody
	public List<Flight> getFlight(@RequestParam String dCity,@RequestParam String aCity,@RequestParam String date)
	{
		return flightService.getFlights(dCity, aCity, date);
	}
	@RequestMapping(value="/transFlight")
	@ResponseBody
	public List<TransFlight> getTransFlight(@RequestParam String dCity,@RequestParam String aCity,@RequestParam String date)
	{
		return flightService.getTransFlights(dCity, aCity, date);
	}
}
