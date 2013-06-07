import java.util.ArrayList;
import java.util.List;


public class TrainDataService {

	public String jsonDataForTrain(String trainId) {
		return "{\"seats\": [{\"coach\": \"A\", \"seat_number\": \"1\", \"coach\": \"A\", \"seat_number\": \"2\"}]}";
	}

	public List<Seat> dataForTrain(String trainId) {
		List<Seat> seats = new ArrayList<Seat>() {{
			add(new Seat("A", 0));
			add(new Seat(null, 0));
			add(new Seat(null, 0));
			add(new Seat(null, 0));
		}};
		return seats;
	}

}
