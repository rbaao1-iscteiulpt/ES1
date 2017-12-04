package antiSpamFilter;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionComparatorTest {

	@Test
	public final void testCompare() {
		int [] a1 = {5, 7};
		int [] a2 = {3, 2};


		SolutionComparator sc = new SolutionComparator();

		int result = sc.compare(a1, a2);

		assertEquals("failure - should be equal", result, 7);

	}

}
