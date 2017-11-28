package antiSpamFilter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Functions {

	private static String rules_path = "AntiSpamConfigurationForBalancedProfessionalAndLeisureMailbox/rules.cf";
	private static String ham_path = "AntiSpamConfigurationForBalancedProfessionalAndLeisureMailbox/ham.log";
	private static String spam_path = "AntiSpamConfigurationForBalancedProfessionalAndLeisureMailbox/spam.log";

	/**
	 * Counts the number of lines in the file rules.cf, which corresponds to the number of rules
	 * 
	 * @param path of file rules.cf
	 * @return the number of rules
	 * @throws FileNotFoundException
	 */
	public static int number_of_rules(String path) throws FileNotFoundException{

		int count = 0;

		Scanner sc = new Scanner(new File(path));

		while (sc.hasNextLine()) {
			count++;
			sc.nextLine();
		}
		sc.close();
		return count;
	}

	/**
	 * Returns an array with the rules inside rules.cf
	 * 
	 * @param rules_path of rules.cf
	 * @return rules inside rules.cf
	 * @throws FileNotFoundException
	 */
	public static ArrayList<String> get_rules(String rules_path) throws FileNotFoundException{
		ArrayList<String> rules = new ArrayList<String>();	
		Scanner sc = new Scanner(new File(rules_path));
		String line;
		while (sc.hasNextLine()) {
			line = sc.nextLine();
			String [] temp = line.split(" ");
			rules.add(temp[0]);	
		}
		sc.close();		
		return rules;
	}

	/**
	 * Returns an array with the weights inside rules.cf
	 * 
	 * @param rules_path of rules.cf
	 * @return weights inside rules.cf
	 * @throws FileNotFoundException
	 */
	public static ArrayList<String> get_weights(String rules_path) throws FileNotFoundException{
		ArrayList<String> weights = new ArrayList<String>();	
		Scanner sc = new Scanner(new File(rules_path));
		String line;
		while (sc.hasNextLine()) {
			line = sc.nextLine();
			String [] temp = line.split(" ");
			weights.add(temp[1]);	
		}
		sc.close();		
		return weights;
	}

	/**
	 * Writes in path (rules.cf) the new weights
	 * 
	 * @param path of rules.cf
	 * @param solution
	 * @throws IOException
	 */
	public static void write_weights(String path, ArrayList<Double> solution) throws IOException{

		ArrayList<String> rules = new ArrayList<String>();

		Scanner sc = new Scanner(new File(path));
		String line;
		int count = 0;

		while (sc.hasNextLine()) {
			line = sc.nextLine();
			String [] temp = line.split(" ");
			rules.add(temp[0] + " " + solution.get(count).toString());	
			count++;
		}

		sc.close();

		// Writes the new weights on the file
		PrintWriter pw = new PrintWriter(new FileWriter(path));

		for (String rule : rules) {
			pw.println(rule);
		}

		pw.close();		
	}

	/**
	 * <p> Converts ham.log/spam.log to an array. 
	 * <p> Each position corresponds to an email. Each position then has another array that contains the rules the
	 *  email breaks.  
	 * 
	 * @param path to ham.log or spam.log
	 * @return array with an array of strings in each position
	 * @throws FileNotFoundException
	 */
	public static ArrayList<ArrayList<String>> file_to_array(String path) throws FileNotFoundException{
		ArrayList<ArrayList<String>> result = new ArrayList<>();
		Scanner sc = new Scanner(new File(path));
		String line;

		while (sc.hasNextLine()) {
			line = sc.nextLine();
			String [] temp = line.split("	| ");
			ArrayList<String> rules_per_line = new ArrayList<>();
			for (int i = 1; i < temp.length; i++) {
				rules_per_line.add(temp[i]);				
			}
			result.add(rules_per_line);		
		}	
		sc.close();		
		return result;
	}

	/**
	 * Evaluates the solution returning the total of FP or FN
	 * 
	 * @param type 0 for FP, 1 for FN
	 * @param rules
	 * @param solution
	 * @param result of file_to_array() on ham.log or spam.log
	 * @return total of FP or FN
	 */
	public static Double evaluate_solution(int type, ArrayList<String> rules, ArrayList<Double> solution, ArrayList<ArrayList<String>> result){
		double total = 0.0;
		for (ArrayList<String> line : result) {
			Double sum = 0.0;
			for (String rule : line) {
				int index = rules.indexOf(rule);

				if (index!=-1){		
					sum += solution.get(index);			
				}else{
					System.out.println("Warning - rules doesn't exist in rules.cf: " + rule);
				}
			}

			if (type == 0){ 
				if (sum > 5.0){ // FP
					total++;
				}					
			}else{ 
				if (sum < 5.0){ // FN				
					total++;
				}							
			}	
		}
		return total;
	}

	public static void main(String[] args) throws IOException{
		ArrayList<String> rules = get_rules(rules_path);
		//		Generate.generate_ham_spam(695, rules, spam_path);
		ArrayList<Double> solution = Generate.generate_solution(337);
		write_weights(rules_path, solution);
		System.out.println("FP: " + evaluate_solution(0, rules, solution, file_to_array(ham_path)));
		System.out.println("FN: " + evaluate_solution(1, rules, solution, file_to_array(spam_path)));

		//Generate.new_ham_spam(ham_path);
	}
}
