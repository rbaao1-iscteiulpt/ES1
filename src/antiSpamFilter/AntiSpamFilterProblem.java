package antiSpamFilter;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.uma.jmetal.problem.impl.AbstractDoubleProblem;
import org.uma.jmetal.solution.DoubleSolution;

public class AntiSpamFilterProblem extends AbstractDoubleProblem {

	static int nRules = 337;
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


		double[] fx = new double[getNumberOfObjectives()];	
		ArrayList<Double> solution_tmp = new ArrayList<>();

		for (int i = 0; i < solution.getNumberOfVariables(); i++) {
			solution_tmp.add(solution.getVariableValue(i));
		}

		fx[0] = Functions.evaluate_solution(0, rules, solution_tmp, ham_result); // FP
		fx[1] = Functions.evaluate_solution(1, rules, solution_tmp, spam_result); // FN


		solution.setObjective(0, fx[0]);
		solution.setObjective(1, fx[1]);
		
	}
}
