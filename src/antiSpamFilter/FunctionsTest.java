package antiSpamFilter;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

public class FunctionsTest {
	
	String rules_path = "jUnitTests/TestFiles/rules.cf";
	
	@Test
	public final void testNumber_of_rules() throws FileNotFoundException {
		Integer numberOfRules = Functions.number_of_rules(rules_path);
		assertSame("failure - should be same", 4, numberOfRules);
	}

	@Test
	public final void testGet_rules() throws FileNotFoundException {
		ArrayList<String> expectedList = new ArrayList<String>();
		expectedList.add("A");
		expectedList.add("B");
		expectedList.add("C");
		expectedList.add("D");
		ArrayList<String> actualList = Functions.get_rules(rules_path);
		assertEquals("failure - lists are not equal", expectedList, actualList);
	}

	@Test
	public final void testGet_weights() throws FileNotFoundException {
		ArrayList<String> expectedList = new ArrayList<String>();
		expectedList.add("1");
		expectedList.add("2");
		expectedList.add("3");
		expectedList.add("4");
		ArrayList<String> actualList = Functions.get_weights(rules_path);
		assertEquals("failure - lists are not equal", expectedList, actualList);
	}

	@Test
	public final void testWrite_weights() throws IOException {
		ArrayList<String> expectedList = new ArrayList<String>();
		expectedList.add("5.0");
		expectedList.add("6.0");
		expectedList.add("7.0");
		expectedList.add("8.0");
		
		ArrayList<Double> solutionList = new ArrayList<Double>();
		solutionList.add(5.0);
		solutionList.add(6.0);
		solutionList.add(7.0);
		solutionList.add(8.0);
		
		Functions.write_weights("jUnitTests/TestFiles/rules_write.cf", solutionList);
		ArrayList<String> actualList = Functions.get_weights("jUnitTests/TestFiles/rules_write.cf");
		assertEquals("failure - lists are not equal", expectedList, actualList);	
	}

	@Test
	public final void testFile_to_array() {
		
	}

	@Test
	public final void testEvaluate_solution() {
		
	}

	@Test
	public final void testChoose_solution() {
		
	}

	@Test
	public final void testGet_solution() {
		
	}

}
