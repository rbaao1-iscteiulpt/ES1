package antiSpamFilter;

import java.util.Comparator;

public class SolutionAdditionComparator implements Comparator<int[]> {

	@Override
	public int compare(int[] arg0, int[] arg1) {		
		return (arg0[0]-arg1[0])+(arg0[1]-arg1[1]);
	}

}
