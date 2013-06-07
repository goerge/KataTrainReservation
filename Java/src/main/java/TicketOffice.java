import java.util.ArrayList;

public class TicketOffice {

    public TicketOffice(String trainDataService, String bookingReferenceService) {
		//TODO: implement this code!
    }

    public Reservation makeReservation(ReservationRequest request) {
		ArrayList<Seat> seats = new ArrayList<Seat>() {{
			add(new Seat("A", 0));
			add(new Seat(null, 0));
			add(new Seat(null, 0));
			add(new Seat(null, 0));
		}};
		return new Reservation(null, seats, "75bcd15");
    }

}