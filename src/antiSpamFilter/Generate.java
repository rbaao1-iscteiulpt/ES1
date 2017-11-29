package antiSpamFilter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

public class Generate {
	
	/**
	 * Generates random weights between -5.0(inclusive) and 5.0(exclusive)
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
	
	public static void generate_ham_spam(int n_emails, ArrayList<String> rules, String path) throws IOException{
		
		PrintWriter pw = new PrintWriter(new FileWriter(path));
		
		Random r = new Random();
		int n;
		int rule;

		for (int i = 0; i < n_emails; i++) {
			
			n = r.nextInt(6)+2;
			String s = "email_" + i;
			for (int j = 0; j < n; j++) {
				rule = r.nextInt(335); 
				s += " " + rules.get(rule);
			}	
			
			pw.println(s);
		}

		pw.close();	
		
	}
	
	public static void new_ham_spam(String path) throws IOException{
		
		ArrayList<ArrayList<String>> novo = Functions.file_to_array(path);
		PrintWriter pw = new PrintWriter(new FileWriter(path));
	
		int count = 0;
		
		for (ArrayList<String> arrayList : novo) {
			String s = "email_" + count;
			for (String string : arrayList) {
				s += " " + string;
			}
			pw.println(s);
			count++;
		}

		pw.close();	
		
	}
}
