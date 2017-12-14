package antiSpamFilter;

import java.util.Comparator;

public class SolutionSubtractionComparator implements Comparator<int[]> {

	@Override
	public int compare(int[] arg0, int[] arg1) {
		return Math.abs((arg1[0]-arg1[1]))-Math.abs((arg0[0]-arg0[1]));
	}

	

}
