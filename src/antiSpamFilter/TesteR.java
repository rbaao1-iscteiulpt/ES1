package antiSpamFilter;

import java.io.File;
import java.io.IOException;

public class TesteR {

	public static void main(String[] args) throws IOException {
			
			Process process = new ProcessBuilder("C:\\Program Files\\R\\R-3.4.2\\bin\\RScript.exe","HV.Boxplot.R")
					.directory(new File("experimentBaseDirectory\\AntiSpamStudy\\R")).start();		

	}

}
