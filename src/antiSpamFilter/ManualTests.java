package antiSpamFilter;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

public class ManualTests {

	@Test
	public void testTestButton(){
		try {
			System.out.println("===TEST TEST BUTTON FROM MANUAL IMPLEMENTATION===");
			Interface testSubject = new Interface();
			testSubject.getTestButton().getActionListeners()[0].actionPerformed(null);
			
			Thread.sleep(1000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	

}
