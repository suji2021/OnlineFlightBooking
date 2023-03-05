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
import com.flightbooking.dao.BookingDao;
import com.flightbooking.exception.BookingAlreadyExistsException;
import com.flightbooking.exception.BookingNotFoundException;
import com.flightbooking.model.Booking;
@RunWith(MockitoJUnitRunner.class)
public class BookingDaoTest {
	@Mock
	private BookingDao bookingDao;
	private Booking booking;
	@Before
	public void setup() {
	booking= new Booking();
	booking.setBookingId(1);
	}
	
	@Test
	public void testGetAllBookings() {
	List<Booking> expectedBookings = new ArrayList<>();
	expectedBookings.add(booking);
	 when(bookingDao.getAllBookings()).thenReturn(expectedBookings);
	List<Booking> actualBookings = bookingDao.getAllBookings();
	assertNotNull(actualBookings);
	assertEquals(expectedBookings.size(), actualBookings.size());
	 assertEquals(expectedBookings.get(0), actualBookings.get(0));
	 }
	
	@Test
	public void testNewBooking() throws BookingAlreadyExistsException {
	 when(bookingDao.newBooking(booking)).thenReturn(booking);
	Booking actualBooking = bookingDao.newBooking(booking);
	assertNotNull(actualBooking);
	assertEquals(booking, actualBooking);
	}
	
	@Test
	public void testCancelBooking() throws BookingNotFoundException {
	bookingDao.cancelBooking(booking.getBookingId());
	}
	
	@Test
	public void testFindByBookingId() throws BookingNotFoundException {
		when(bookingDao.findByBookingId(booking.getBookingId())).thenReturn(booking);
		Booking actualBooking = bookingDao.findByBookingId(booking.getBookingId());
		assertNotNull(actualBooking);
		assertEquals(booking, actualBooking);
		}	
	}