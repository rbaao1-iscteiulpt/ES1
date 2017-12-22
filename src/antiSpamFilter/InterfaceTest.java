package antiSpamFilter;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.Test;

/**
 * This class houses several tests pertaining to the Graphical User Interface. <p>
 * Several tests make use of a Thread.sleep() function to give Swing some time to update whatever values
 * it has to in order for the test to make sense. <p>
 * Do not instantiate this class if you don't know what you're doing!
 * @author pvmpa-iscteiulpt, afgos-iscteiulpt
 *
 */
public class InterfaceTest {
		
	/**
	 * Tests if the Test button in the Manual Implementation works properly when no rules.cf/spam.log/ham.log 
	 * are provided. It shouldn't have any effect on the FP/FN counters.
	 */
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
	
	/**
	 * Tests if the Test button in the Manual Implementation works properly when rules.cf/spam.log/ham.log 
	 * are provided. The FP/FN counters must change.
	 */
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
	
	/**
	 * Tests the rules/weights saving function by comparing the saved files with the information in the
	 * interface's text areas. They should hold the same information.
	 */
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
	
	/**
	 * Tests whether changing the path to a correct Rules file does anything or not.
	 * The path to rules.cf should change.
	 */
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
	
	/**
	 * Tests whether NOT changing the path to the Rules file while it's empty does anything or not.
	 * The path to rules.cf should not change and/or end the program in a catastrophic manner.
	 */
	@Test
	public void testCancelChangeRules(){
		try {
			System.out.println("===TEST CANCEL RULES.CF IMPORT===");
			Interface testSubject = new Interface();
			System.out.println("choose cancel");
			testSubject.changeRules();
			
			Thread.sleep(1000);
			
			assertThat(testSubject.getRulesPath().getText(), is(""));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Tests whether the program can handle the user choosing the wrong rules.cf file.
	 * The program should toss an error prompt at the user and not change the path to the file. 
	 */
	@Test
	public void testChangeRules_Failure(){
		try {
			System.out.println("===TEST UNSUCCESSFUL RULES.CF IMPORT===");
			Interface testSubject = new Interface();
			System.out.println("chooose any except rules");
			testSubject.changeRules();
			
			Thread.sleep(2000);
			
			assertThat(testSubject.getRulesPath().getText(), is(""));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Tests whether changing the path to ham.log does anything. The user should provide a correct path.
	 * The path to Ham should change.
	 */
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
	
	/**
	 * Tests if Ham path is blank after canceling the change,
	 * "cancel" must be pressed.
	 */
	@Test
	public void testCancelChangeHam(){
		try {
			System.out.println("===TEST Cancel SUCCESSFUL HAM.LOG IMPORT===");
			Interface testSubject = new Interface();
			System.out.println("chooose cancel");
			testSubject.changeHam();
			
			Thread.sleep(1000);
			
			assertThat(testSubject.getHamPath().getText(), is(""));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Tests if spam path is changed after clicking "change" button
	 * Spam file must be choosed.
	 */
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
	
	/**
	 * Tests if Spam path is blank after canceling the change,
	 * "cancel" must be pressed.
	 */
	@Test
	public void testCancelChangeSpam(){
		try {
			System.out.println("===TEST Cancel SUCCESSFUL SPAM.LOG IMPORT===");
			Interface testSubject = new Interface();
			System.out.println("chooose cancel");
			testSubject.changeSpam();
			
			Thread.sleep(1000);
			
			assertThat(testSubject.getSpamPath().getText(), is(""));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Checks if values of FP and FN are changed after clicking "generate" button
	 * The files are choosed by orde: rules, spam, ham.
	 */
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
			
			Thread.sleep(30000);
			assertNotEquals(testSubject.getaFalseNegField().getText(), "0");
			assertNotEquals(testSubject.getaFalsePosField().getText(), "0");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Tests if Auto Save Button saves information on automatic interface
	 * Rules path must be choosen.
	 */
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
