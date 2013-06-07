import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class TrainDataServiceTest {

	private TrainDataService trainDataService = new TrainDataService(null);

	@Test
	public void jsonTrainDataService() {
		assertEquals(
				"{\"seats\": [{\"coach\": \"A\", \"seat_number\": \"1\", \"coach\": \"A\", \"seat_number\": \"2\"}]}",
				trainDataService.jsonDataForTrain("express_2000"));
	}

	@Test
	public void jsonIsConvertedToPOJOs() throws Exception {
		List<Seat> seats = trainDataService.dataForTrain("");
		assertEquals(4, seats.size());
	}
}
