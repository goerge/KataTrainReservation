import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TicketOfficeTest {

    private TicketOffice office;
	private TrainDataService trainDataServiceStub;
	private BookingReferenceService bookingReferenceServiceStub;

    @Before
    public void setUpTicketOffice() {
    	office = new TicketOffice(trainDataServiceStub, bookingReferenceServiceStub);
    }

	@Test
    public void reserveSeats() {
        ReservationRequest request = new ReservationRequest("express_2000", 4);

        Reservation reservation = office.makeReservation(request);

        assertEquals(4, reservation.seats.size());
        assertEquals("A", reservation.seats.get(0).coach);
        assertEquals("75bcd15", reservation.bookingId);
    }
}
