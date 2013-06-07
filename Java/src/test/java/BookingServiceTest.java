import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class BookingServiceTest {

	@Test
	public void bookigService() {
		assertEquals("75bcd15", new BookingService("http://localhost:8081").createBookingReference());
	}

}
