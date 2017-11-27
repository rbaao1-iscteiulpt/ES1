package antiSpamFilter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Functions {

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
	 * Writes in rules.cf the new weights
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
	 * Evaluates the solution returning the total of FP or FN
	 * 
	 * @param type 0 for FP, 1 for FN
	 * @param rules
	 * @param solution
	 * @param path of ham.log or spam.log
	 * @return number of FP or FN
	 * @throws FileNotFoundException
	 */
	public static int evaluate(int type, ArrayList<String> rules, ArrayList<Double> solution, String path) throws FileNotFoundException{

		int total = 0;
		int new_rules = 0;

		Scanner sc = new Scanner(new File(path));
		String line;
		double sum = 0.0;

		while (sc.hasNextLine()) {
			line = sc.nextLine();
			String [] temp = line.split("	| ");	
			sum = 0;			
			for (int i = 1; i < temp.length; i++) {
				int index = rules.indexOf(temp[i]);
				if (index==-1){		
					new_rules++;
				}else{
					sum += solution.get(index);
				}
			}
			if (type == 0){ 
				if (sum > 5.0) // FP
					total++;
			}else{ 
				if (sum < 5.0) // FN
					total++;			
			}
		}	
		sc.close();
		// System.out.println(new_rules);
		return total;
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
	public static int evaluate2(int type, ArrayList<String> rules, ArrayList<Double> solution, ArrayList<ArrayList<String>> result){
		int total = 0;
		for (ArrayList<String> line : result) {
			double sum = 0.0;
			
			for (String rule : line) {
				int index = rules.indexOf(rule);

				if (index!=-1){		
					sum += solution.get(index);
				}		
			}

			if (type == 0){ 
				if (sum > 5.0) // FP
					total++;
			}else{ 
				if (sum < 5.0) // FN
					total++;			
			}	
		}
		return total;
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
	 * Returns an array with the rules inside rules.cf
	 * 
	 * @param path of rules.cf
	 * @return rules inside rules.cf
	 * @throws FileNotFoundException
	 */
	public static ArrayList<String> get_rules(String path) throws FileNotFoundException{
		ArrayList<String> rules = new ArrayList<String>();	
		Scanner sc = new Scanner(new File(path));
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
	 * Classe para teste, gera pesos enquanto não temos o user que as dê
	 * 
	 * @param number of rules
	 * @return array with weights for each rule
	 */
	public static ArrayList<Double> generate_solution(int nRules){

		ArrayList<Double> solutions = new ArrayList<>();

		Random r = new Random();
		double d;

		for (int i = 0; i < nRules; i++) {
			d = r.nextDouble()*10.0-5.0;
			solutions.add(d);
		}		
		return solutions;
	}

	public static void main(String[] args) throws IOException{
		//System.out.println(number_of_rules("AntiSpamConfigurationForBalancedProfessionalAndLeisureMailbox/rules.cf"));
		//generate_solution(335);
		//write_weights("AntiSpamConfigurationForBalancedProfessionalAndLeisureMailbox/rules.cf", generate_solution(335));
		//		System.out.println(evaluate(0, get_rules("AntiSpamConfigurationForBalancedProfessionalAndLeisureMailbox/rules.cf")
		//				,generate_solution(335),"AntiSpamConfigurationForBalancedProfessionalAndLeisureMailbox/ham.log"));
		//get_rules("AntiSpamConfigurationForBalancedProfessionalAndLeisureMailbox/rules.cf");
//		ArrayList<ArrayList<String>> x = file_to_array("AntiSpamConfigurationForBalancedProfessionalAndLeisureMailbox/ham.log");
//		ArrayList<String> rules = get_rules("AntiSpamConfigurationForBalancedProfessionalAndLeisureMailbox/rules.cf");
//		evaluate2(0, rules, generate_solution(21),x);
	}
}
