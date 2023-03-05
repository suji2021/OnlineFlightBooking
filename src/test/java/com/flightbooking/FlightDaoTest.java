package com.flightbooking;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.InjectMocks;

import com.flightbooking.controller.AdminController;
import com.flightbooking.dao.FlightDao;
import com.flightbooking.exception.FlightNotFoundException;
import com.flightbooking.model.Flight;

public class FlightDaoTest {
	@InjectMocks
	private AdminController adminController;
	@Test
	public void testGetAllFlights() {
	FlightDao flightDao= mock(FlightDao.class);
	List<Flight> expectedFlights = new ArrayList<>();
	expectedFlights.add(new Flight());
	expectedFlights.add(new Flight());
	when(flightDao.getAllFlights()).thenReturn(expectedFlights);
	List<Flight> actualFlights = flightDao.getAllFlights();
	assertEquals(expectedFlights, actualFlights);
	}
	
	@Test
	public void testUpdateFlight() throws FlightNotFoundException {
	FlightDao flightDao= mock(FlightDao.class);
	Flight flightToUpdate = new Flight();
	Flight updatedFlight = new Flight();
	when(flightDao.updateFlight(flightToUpdate, 0)).thenReturn(updatedFlight);
	Flight actualFlight = flightDao.updateFlight(flightToUpdate, 0);
	assertEquals(updatedFlight, actualFlight);
	}
}
