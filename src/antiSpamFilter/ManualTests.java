package antiSpamFilter;

import static org.junit.Assert.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import org.junit.Test;

public class ManualTests {

	public void testTestButton(){
		try {
			System.out.println("===TEST TEST BUTTON FROM MANUAL IMPLEMENTATION===");
			Interface testSubject = new Interface();
//			testSubject.changeRules();
//			testSubject.changeSpam();
//			testSubject.changeHam();
			testSubject.getTestButton().getActionListeners()[0].actionPerformed(null);
			
			Thread.sleep(1000);
			assertEquals(testSubject.getmFalseNegField().getText(), "0");
			assertEquals(testSubject.getmFalsePosField().getText(), "0");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public void testTestButton2(){
		try {
			System.out.println("===TEST 2 TEST BUTTON FROM MANUAL IMPLEMENTATION===");
			Interface testSubject = new Interface();
			testSubject.changeRules();
			testSubject.changeSpam();
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
	public void testSaveButton() {
		try {
			System.out.println("===TEST SAVE BUTTON FROM MANUAL IMPLEMENTATION===");
			Interface testSubject = new Interface();
			testSubject.getFrame().setVisible(true);
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
	

}
