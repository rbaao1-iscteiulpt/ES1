package antiSpamFilter;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.uma.jmetal.problem.impl.AbstractDoubleProblem;
import org.uma.jmetal.solution.DoubleSolution;

public class AntiSpamFilterProblem extends AbstractDoubleProblem {

	static int nRules = 335;
	private static String rules_path = "AntiSpamConfigurationForBalancedProfessionalAndLeisureMailbox/rules.cf";
	private static String ham_path = "AntiSpamConfigurationForBalancedProfessionalAndLeisureMailbox/ham.log";
	private static String spam_path = "AntiSpamConfigurationForBalancedProfessionalAndLeisureMailbox/spam.log";
	private ArrayList<String> rules;
	private ArrayList<ArrayList<String>> ham_result;
	private ArrayList<ArrayList<String>> spam_result;

	public AntiSpamFilterProblem() {
		this(nRules);
	}

	public AntiSpamFilterProblem(Integer numberOfVariables) {

		try {
			rules = Functions.get_rules(rules_path);
			ham_result = Functions.file_to_array(ham_path);
			spam_result = Functions.file_to_array(spam_path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int count = 0;

		setNumberOfVariables(numberOfVariables);
		setNumberOfObjectives(2);
		setName("AntiSpamFilterProblem");

		List<Double> lowerLimit = new ArrayList<>(getNumberOfVariables()) ;
		List<Double> upperLimit = new ArrayList<>(getNumberOfVariables()) ;

		for (int i = 0; i < getNumberOfVariables(); i++) {
			lowerLimit.add(-5.0);
			upperLimit.add(5.0);
		}

		setLowerLimit(lowerLimit);
		setUpperLimit(upperLimit);
	}

	public void evaluate(DoubleSolution solution){

//		double aux, xi, xj;
		double[] fx = new double[getNumberOfObjectives()];	
		ArrayList<Double> solution2 = new ArrayList<>();
//		double[] x = new double[getNumberOfVariables()];
		for (int i = 0; i < solution.getNumberOfVariables(); i++) {
			//			x[i] = solution.getVariableValue(i);
			solution2.add(solution.getVariableValue(i));
		}

		fx[0] = Functions.evaluate2(0, rules, solution2, ham_result);
		fx[1] = Functions.evaluate2(1, rules, solution2, spam_result);

		//		System.out.println("FP: " + fx[0] + ", FN: " + fx[1]);

		//		fx[0] = 0.0;
		//		for (int var = 0; var < solution.getNumberOfVariables() - 1; var++) {
		//			//Invocar a funçã de avaliar e calcular os FP
		//			fx[0] += Math.abs(x[0]); // Example for testing
		//		}
		//
		//		fx[1] = 0.0;
		//		for (int var = 0; var < solution.getNumberOfVariables(); var++) {
		//			//Invocar a função de avaliar e calcular os FN
		//			fx[1] += Math.abs(x[1]); // Example for testing
		//		}

		solution.setObjective(0, fx[0]);
		solution.setObjective(1, fx[1]);
	}
}
