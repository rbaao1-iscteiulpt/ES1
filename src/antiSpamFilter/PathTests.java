package antiSpamFilter;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

public class PathTests {
	
	@Test
	public void testChangeRules(){
		try {
			System.out.println("===TEST SUCCESSFUL RULES.CF IMPORT===");
			Interface testSubject = new Interface();
			testSubject.changeRules();
			
			Thread.sleep(1000);
			
			assertThat(testSubject.getRulesPath().getText(), is(not("")));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testChangeRules_Failure(){
		try {
			System.out.println("===TEST UNSUCCESSFUL RULES.CF IMPORT===");
			Interface testSubject = new Interface();
			testSubject.changeRules();
			
			Thread.sleep(1000);
			
			assertThat(testSubject.getRulesPath().getText(), is(""));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testChangeHam(){
		try {
			System.out.println("===TEST SUCCESSFUL HAM.LOG IMPORT===");
			Interface testSubject = new Interface();
			testSubject.changeHam();
			
			Thread.sleep(1000);
			
			assertThat(testSubject.getHamPath().getText(), is(not("")));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testChangeSpam(){
		try {
			System.out.println("===TEST SUCCESSFUL SPAM.LOG IMPORT===");
			Interface testSubject = new Interface();
			testSubject.changeSpam();
			
			Thread.sleep(1000);
			
			assertThat(testSubject.getSpamPath().getText(), is(not("")));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
}
