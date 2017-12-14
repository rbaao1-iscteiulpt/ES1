package antiSpamFilter;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionComparatorTest {

	@Test
	public final void testAdditionCompare() {
		int [] a1 = {5, 7};
		int [] a2 = {3, 2};


		SolutionAdditionComparator sc = new SolutionAdditionComparator();

		int result = sc.compare(a1, a2);

		assertEquals("failure - should be equal", result, 7);

	}
	
	@Test
	public final void testSubtractionCompare(){
		int[] a1 = {2, 2};
		int[] a2 = {4, 4};
		
		SolutionSubtractionComparator sc = new SolutionSubtractionComparator();
		
		int result = sc.compare(a1, a2);
		System.out.println("Result == 0? Actual: " + result);
		
		assertTrue("Something is wrong here! Result == 0 FAILURE", result == 0);
		
		a1[0] = 1; a1[1] = 4;
		a2[0] = 3; a2[1] = 4;
		
		result = sc.compare(a1, a2);
		
		System.out.println("Result < 0? Actual: " + result);
		
		assertTrue("Something is wrong here! Result < 0 FAILURE", result < 0);
		
		result = sc.compare(a2, a1);
		
		System.out.println("Result > 0? Actual: " + result);
		
		assertTrue("Something is wrong here! Result > 0 FAILURE", result > 0);
		
	}

}
