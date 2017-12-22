package antiSpamFilter;

import java.io.File;
import java.io.IOException;

public class TesteR {

	public static void main(String[] args) throws IOException {
			
//			Process process = new ProcessBuilder("C:\\Program Files\\R\\R-3.4.2\\bin\\RScript.exe","HV.Boxplot.R")
//					.directory(new File("experimentBaseDirectory\\AntiSpamStudy\\R")).start();		
					
			Process process1 = new ProcessBuilder("C:\\Users\\Rodrigo\\AppData\\Local\\Programs\\MiKTeX 2.9\\miktex\\bin\\x64\\miktex-texworks.exe","AntiSpamStudy.tex")
					.directory(new File("experimentBaseDirectory\\AntiSpamStudy\\latex")).start();		
	}

}
