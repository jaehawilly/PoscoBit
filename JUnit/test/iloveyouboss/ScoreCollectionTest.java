package iloveyouboss;

import static org.junit.Assert.*;
import org.hamcrest.CoreMatchers.*;
import org.junit.*;

public class ScoreCollectionTest {
	@Test
	public void ScoreCollectionTest() {
		// 준비
		ScoreCollection collection = new ScoreCollection();
		collection.add(()->5);
		collection.add(()->7);
		
		// 실행
		int actualResult = collection.arithmeticMean();
		
		// 단언
		assertEquals(actualResult, 6);
	}
}
