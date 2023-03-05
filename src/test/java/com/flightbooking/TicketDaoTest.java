package com.flightbooking;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.flightbooking.dao.TicketDao;
import com.flightbooking.model.Ticket;
public class TicketDaoTest {
	@Mock
	private TicketDao ticketDaoMock;
	@Before
	public void setUp() {
	MockitoAnnotations.initMocks(this);
}
	
	@Test
	public void testFindAllTickets() {
	List<Ticket> expectedTickets = new ArrayList<>();
	expectedTickets.add(new Ticket());
	expectedTickets.add(new Ticket());
	when(ticketDaoMock.findAllTickets()).thenReturn(expectedTickets);	
	List<Ticket> actualTickets = ticketDaoMock.findAllTickets();
	assertEquals(expectedTickets, actualTickets);
	}	
	
	@Test
	public void testAddTicket() {
	Ticket expectedTickets = new Ticket();
	when(ticketDaoMock.addTicket(expectedTickets)).thenReturn(expectedTickets);
	Ticket actualTickets = ticketDaoMock.addTicket(expectedTickets);
	assertEquals(expectedTickets, actualTickets);
	}	

}