import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

public class TicketOfficeTest {

    @Test
    public void reserveSeats() {
        TicketOffice office = new TicketOffice("http://localhost:8081", "http://localhost:8082");
        ReservationRequest request = new ReservationRequest("express_2000", 4);

        Reservation reservation = office.makeReservation(request);

        assertEquals(4, reservation.seats.size());
        assertEquals("A", reservation.seats.get(0).coach);
        assertEquals("75bcd15", reservation.bookingId);
    }

    @Test
	public void verifyServiceAreInstantiatedOnce() throws Exception {
		BookingService bookingService = mock(BookingService.class);
		TrainDataService trainDataService = mock(TrainDataService.class);

		new TicketOffice(trainDataService, bookingService).makeReservation(new ReservationRequest("express_2000", 4));

		verify(bookingService).createBookingReference();
		verify(trainDataService).dataForTrain("express_2000");
	}
}
