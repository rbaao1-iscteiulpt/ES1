package antiSpamFilter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Tests whether ham.log and spam.log have False Negatives or False Positives, respectively.
 * @author pvmpa-iscteiulpt
 * @param path_rules
 * @param path_ham
 * @param path_spam
 * @throws FileNotFoundException
 */
public class EMailFNFP_Scanner {

	private static final double SPAM_THRESHOLD = 5.0;
	private static final double MIN_VALUE = -5.0;
	
	private File path_rules;
	private File path_ham;
	private File path_spam;
	

	public EMailFNFP_Scanner(File path_rules, File path_ham, File path_spam){
		this.path_rules = path_rules;
		this.path_ham = path_ham;
		this.path_spam = path_spam;
		
		//testing existence of files
		
		try {
			Scanner test_rules = new Scanner(path_rules);
			Scanner test_ham = new Scanner(path_ham);
			Scanner test_spam = new Scanner(path_spam);
			
			test_rules.close();
			test_ham.close();
			test_spam.close();
		} catch (FileNotFoundException e) {
			System.out.println("ATTENTION: FILE NOT FOUND!");
			e.printStackTrace();
		}
		
	}
	
	public void scan() throws FileNotFoundException{
		Scanner rules = new Scanner(path_rules);
		Scanner ham = new Scanner(path_ham);
		Scanner spam = new Scanner(path_spam);
		
	}
	
	
}
