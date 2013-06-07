import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class TrainDataServiceTest {

	@Test
	public void jsonTrainDataService() {
		assertEquals(
				"{\"seats\": [{\"coach\": \"A\", \"seat_number\": \"1\", \"coach\": \"A\", \"seat_number\": \"2\"}]}",
				new TrainDataService(null).jsonDataForTrain("express_2000"));
	}

	@Test
	public void jsonIsConvertedToPOJOs() throws Exception {
		List<Seat> seats = new TrainDataService(null).dataForTrain("");
		assertEquals(4, seats.size());
	}
}
