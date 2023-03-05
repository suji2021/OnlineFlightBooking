package com.flightbooking.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightbooking.exception.AirportNotFoundException;
import com.flightbooking.model.Airport;
import com.flightbooking.repository.AirportRepository;

@Service
public class AirportDaoImpl implements AirportDao{

	@Autowired
	private AirportRepository repository;

	
	public List<Airport> getAllAirport() {
		return repository.findAll();
	}

	
	public Airport addAirport(Airport airport) {
		return repository.save(airport);
	}

	
	public Airport updateAirport(Airport airport, long airportId) throws AirportNotFoundException {
		Airport a =repository.findById(airportId).get();
		if(a==null) {
			throw new AirportNotFoundException();
		}		
		a.setAirportName(airport.getAirportName());
		return this.repository.save(a);
	}
	
}


