package antiSpamFilter;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.Test;

public class InterfaceTest {
		
	@Test
	public void testTestButton(){
		try {
			System.out.println("===TEST TEST BUTTON FROM MANUAL IMPLEMENTATION===");
			Interface testSubject = new Interface();

			testSubject.getTestButton().getActionListeners()[0].actionPerformed(null);
			
			Thread.sleep(1000);
			assertEquals(testSubject.getmFalseNegField().getText(), "0");
			assertEquals(testSubject.getmFalsePosField().getText(), "0");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testTestButton2(){
		try {
			System.out.println("===TEST 2 TEST BUTTON FROM MANUAL IMPLEMENTATION===");
			Interface testSubject = new Interface();
			System.out.println("chooose rules");
			testSubject.changeRules();
			System.out.println("chooose spam");
			testSubject.changeSpam();
			System.out.println("chooose ham");
			testSubject.changeHam();
			testSubject.getTestButton().getActionListeners()[0].actionPerformed(null);
			
			Thread.sleep(1000);
			assertNotEquals(testSubject.getmFalseNegField().getText(), "0");
			assertNotEquals(testSubject.getmFalsePosField().getText(), "0");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testManualSaveButton() {
		try {
			System.out.println("===TEST SAVE BUTTON FROM MANUAL IMPLEMENTATION===");
			Interface testSubject = new Interface();
			testSubject.getFrame().setVisible(true);
			System.out.println("chooose rules");
			testSubject.changeRules();
			
			Thread.sleep(5000);
			
			testSubject.getMSaveButton().getActionListeners()[0].actionPerformed(null);
			ArrayList<String> rules_file = Functions.get_rules(testSubject.getRulesPath().getText());
			ArrayList<String> weights_file = Functions.get_weights(testSubject.getRulesPath().getText());
			
			String temp1= "";
			String temp2= "";
			for(String s : rules_file) {
				temp1+=s + "\n";
			}
			for(String s : weights_file) {
				temp2+=s + "\n";
			}
			
			assertEquals(temp1, testSubject.getmRulesTextArea().getText());
			assertEquals(temp2, testSubject.getmWeightTextArea().getText());
			
		}	catch (InterruptedException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testChangeRules(){
		try {
			System.out.println("===TEST SUCCESSFUL RULES.CF IMPORT===");
			Interface testSubject = new Interface();
			System.out.println("chooose rules");
			testSubject.getRulesButton().getActionListeners()[0].actionPerformed(null);
			
			Thread.sleep(1000);
			
			assertThat(testSubject.getRulesPath().getText(), is(not("")));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testCancelChangeRules(){
		try {
			System.out.println("===TEST CANCEL RULES.CF IMPORT===");
			Interface testSubject = new Interface();
			System.out.println("chooose cancel");
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
			System.out.println("chooose any except rules");
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
			System.out.println("chooose ham");
			testSubject.getHamButton().getActionListeners()[0].actionPerformed(null);
			
			Thread.sleep(1000);
			
			assertThat(testSubject.getHamPath().getText(), is(not("")));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testCancelChangeHam(){
		try {
			System.out.println("===TEST Cancel SUCCESSFUL HAM.LOG IMPORT===");
			Interface testSubject = new Interface();
			System.out.println("chooose cancel");
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
			System.out.println("chooose spam");
			testSubject.getSpamButton().getActionListeners()[0].actionPerformed(null);
			
			Thread.sleep(1000);
			
			assertThat(testSubject.getSpamPath().getText(), is(not("")));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testCancelChangeSpam(){
		try {
			System.out.println("===TEST Cancel SUCCESSFUL SPAM.LOG IMPORT===");
			Interface testSubject = new Interface();
			System.out.println("chooose cancel");
			testSubject.changeSpam();
			
			Thread.sleep(1000);
			
			assertThat(testSubject.getSpamPath().getText(), is(not("")));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void generateButton() {
		try {
			System.out.println("===TEST Generate BUTTON FROM AUTO IMPLEMENTATION===");
			Interface testSubject = new Interface();
			System.out.println("chooose rules");
			testSubject.changeRules();
			System.out.println("chooose spam");
			testSubject.changeSpam();
			System.out.println("chooose ham");
			testSubject.changeHam();
			testSubject.getGenerateButton().getActionListeners()[0].actionPerformed(null);
			
			Thread.sleep(1000);
			assertEquals(testSubject.getaFalseNegField().getText(), "0");
			assertEquals(testSubject.getaFalsePosField().getText(), "0");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public final void testAdditionCompare() {
		int [] a1 = {5, 7};
		int [] a2 = {3, 2};


		SolutionAdditionComparator sc = new SolutionAdditionComparator();

		int result = sc.compare(a1, a2);

		assertEquals("failure - should be equal", result, 7);

	}
	
	@Test
	public void testAutoSaveButton() {
		try {
			System.out.println("===TEST SAVE BUTTON FROM AUTO IMPLEMENTATION===");
			Interface testSubject = new Interface();
			testSubject.getFrame().setVisible(true);
			System.out.println("chooose rules");
			testSubject.changeRules();
			
			Thread.sleep(5000);
			
			testSubject.getASaveButton().getActionListeners()[0].actionPerformed(null);
			ArrayList<String> rules_file = Functions.get_rules(testSubject.getRulesPath().getText());
			ArrayList<String> weights_file = Functions.get_weights(testSubject.getRulesPath().getText());
			
			String temp1= "";
			String temp2= "";
			for(String s : rules_file) {
				temp1+=s + "\n";
			}
			for(String s : weights_file) {
				temp2+=s + "\n";
			}
			
			assertEquals(temp1, testSubject.getmRulesTextArea().getText());
			assertEquals(temp2, testSubject.getmWeightTextArea().getText());
			
		}	catch (InterruptedException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
