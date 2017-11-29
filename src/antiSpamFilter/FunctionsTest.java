package antiSpamFilter;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

public class FunctionsTest {

	@Test
	public final void testNumber_of_rules() throws FileNotFoundException {
		Integer numberOfRules = Functions.number_of_rules("jUnitTests/TestFiles/rules.cf");
		assertSame("should be same", 4, numberOfRules);
	}

	@Test
	public final void testGet_rules() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGet_weights() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testWrite_weights() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testFile_to_array() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testEvaluate_solution() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testChoose_solution() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGet_solution() {
		fail("Not yet implemented"); // TODO
	}

}
