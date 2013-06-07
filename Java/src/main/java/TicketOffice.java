import java.util.List;

public class TicketOffice {

	private final TrainDataService trainDataService;
	private final BookingService bookingService;

	public TicketOffice(String trainDataService, String bookingReferenceService) {
		this(new TrainDataService(trainDataService), new BookingService(bookingReferenceService));
	}

	public TicketOffice(TrainDataService trainDataService,
			BookingService bookingService) {
		this.trainDataService = trainDataService;
		this.bookingService = bookingService;
	}

	public Reservation makeReservation(ReservationRequest request) {
		List<Seat> seats = trainDataService.dataForTrain(request.trainId);
		return new Reservation(request.trainId, seats,
				bookingService.createBookingReference());
	}

}