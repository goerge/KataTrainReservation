import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TrainDataServiceTest {

	@Test
	public void trainDataService() {
		assertEquals(
				"{\"seats\": [{\"coach\": \"A\", \"seat_number\": \"1\", \"coach\": \"A\", \"seat_number\": \"2\"}]}",
				new TrainDataService().dataForTrain("express_2000"));
	}

}
