public class TicketOffice {

    private final BookingReferenceService bookingReferenceService;

	public TicketOffice(TrainDataService trainDataService, BookingReferenceService bookingReferenceService) {
		this.bookingReferenceService = bookingReferenceService;
    }

    public Reservation makeReservation(ReservationRequest request) {
		return new Reservation(null, null, bookingReferenceService.bookingReference());
    }

}