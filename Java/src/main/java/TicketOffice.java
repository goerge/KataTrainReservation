import java.util.List;

public class TicketOffice {

    private final BookingReferenceService bookingReferenceService;
	private final TrainDataService trainDataService;

	public TicketOffice(TrainDataService trainDataService, BookingReferenceService bookingReferenceService) {
		this.trainDataService = trainDataService;
		this.bookingReferenceService = bookingReferenceService;
    }

    public Reservation makeReservation(ReservationRequest request) {
    	List<Seat> dataForTrain = trainDataService.dataForTrain(request.trainId);
		if(dataForTrain.size() >= request.seatCount) {
			return new Reservation(null, null, bookingReferenceService.bookingReference());
		}
		return new Reservation(request.trainId, null, null);
    }
}