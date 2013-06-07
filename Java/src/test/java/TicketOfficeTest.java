import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TicketOfficeTest {

    private TicketOffice office;
	@Mock TrainDataService trainDataServiceStub;
	@Mock BookingReferenceService bookingReferenceServiceStub;

    @Before
    public void setUpTicketOffice() {
    	MockitoAnnotations.initMocks(this);
    	office = new TicketOffice(trainDataServiceStub, bookingReferenceServiceStub);
    }

    @Ignore
	@Test
    public void reserveSeats() {
        ReservationRequest request = new ReservationRequest("express_2000", 4);

        Reservation reservation = office.makeReservation(request);

        assertEquals(4, reservation.seats.size());
        assertEquals("A", reservation.seats.get(0).coach);
        assertEquals("75bcd15", reservation.bookingId);
    }

	@Test
	public void reservationContainsIdFromBookingService() throws Exception {
		when(bookingReferenceServiceStub.bookingReference()).thenReturn("1");
		Reservation reservation = office.makeReservation(new ReservationRequest("train", 1));
		assertThat(reservation.bookingId, is("1"));
	}

	@Test
	public void twoReservationsHaveConsecutiveBookingIds() throws Exception {
		when(bookingReferenceServiceStub.bookingReference()).thenReturn("1", "2");
		assertThat(office.makeReservation(new ReservationRequest("train", 1)).bookingId, is("1"));
		assertThat(office.makeReservation(new ReservationRequest("train", 1)).bookingId, is("2"));
	}

	@Test
	public void reservationForTrainWithoutSeats() throws Exception {
		when(trainDataServiceStub.dataForTrain("train")).thenReturn(new ArrayList<Seat>());
		assertThat(office.makeReservation(new ReservationRequest("train", 1)).bookingId, is(nullValue()));
	}
}
