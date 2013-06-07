import java.util.List;

public class TicketOffice {

    public TicketOffice(String trainDataService, String bookingReferenceService) {
		//TODO: implement this code!
    }

    public Reservation makeReservation(ReservationRequest request) {
		List<Seat> seats = new TrainDataService().dataForTrain(request.trainId);
		return new Reservation(null, seats, new BookingService(null).createBookingReference());
    }

}