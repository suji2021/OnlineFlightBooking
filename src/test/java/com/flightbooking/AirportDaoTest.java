package com.flightbooking;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import com.flightbooking.dao.AirportDao;
import com.flightbooking.model.Airport;

@RunWith(MockitoJUnitRunner.class)
public class AirportDaoTest {

    @Mock
    private AirportDao airportDao;
    private Airport airport;

    @Before
	public void setup() {
	airport= new Airport();
	airport.setAirportId(1);
	}

	@Test
    public void testGetAllAirports() {
		List<Airport> expectedAirports = new ArrayList<>();
		expectedAirports.add(airport);
		 when(airportDao.getAllAirport()).thenReturn(expectedAirports);
		List<Airport> actualAirports = airportDao.getAllAirport();
		assertNotNull(actualAirports);
		assertEquals(expectedAirports.size(), actualAirports.size());
		 assertEquals(expectedAirports.get(0), actualAirports.get(0));
        
    }
	
	@Test
	public void testAddAirport() {
	 when(airportDao.addAirport(airport)).thenReturn(airport);
	Airport actualAirport =airportDao.addAirport(airport);
	assertNotNull(actualAirport);
	assertEquals(airport, actualAirport);
	}
	
	
}
