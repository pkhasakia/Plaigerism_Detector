/*
 * Author: Preet Khasakia
 * 
 */
package algo;
import java.util.*;
import java.util.stream.Collectors;
import java.io.*;
import java.lang.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;


public class compare {
	
	public static double similarity(File testFiles, File matchFiles) throws IOException  {
		
		//Read the files
		BufferedReader br1 = new BufferedReader(new FileReader(testFiles));
		BufferedReader br2 = new BufferedReader(new FileReader(matchFiles));
		
		//String used to read line by line with buffer
		String st1 = br1.readLine();
		String st2 = br2.readLine();
		
		//Split all white spaces between strings
		String[] splitS1 = st1.split(" ");
		String[] splitS2 = st2.split(" ");
		
		//Algorithm to compute the plagiarism
		double similarities = 0;								//Similarity counter
		for(int i = 0; i < splitS1.length; i++){
			 for(int j = 0; j < splitS2.length; j++) {
				 if(splitS1[i].contentEquals(splitS2[j])) {		//Check whether the string contents match in both files
					 ++similarities;
					 break;										//To eliminate duplicates of match words 
				 } 
			 }
		}
		return (similarities) / (double) splitS1.length;		//Output the result
}
		
	 public static void main(String[] args) throws IOException {
		 
		compare c = new compare();


		//NOTE: IF YOU ARE TESTING THIS CODE, PLEASE CHANGE THE FILE PATHS!
		
		//Paths as string to locate the text files
		String tFilePath = "path\\test files";
		String mFilePath = "path\\match files";
		
		//File objects for the paths
		File tFiles = new File(tFilePath);
		File mFiles = new File(mFilePath);
		 
		if((tFiles.exists() && mFiles.exists()) && (tFiles.isDirectory() && mFiles.isDirectory())){		//Checks if directories and files exist
		
		//Lists all files
		File[] files1 = tFiles.listFiles();
		File[] files2 = mFiles.listFiles();
		
		//Write to a new CSV file and append the results to it
		PrintWriter pw = new PrintWriter(new File("path\\sample result.csv"));
		StringBuilder sb = new StringBuilder();
		
		/*
		 *This part of the code uses two for loops to print the results in a CSV file.
		 */
		for(int i = 0; i<files1.length; i++) {
			 for(int j = 0; j < files2.length;j++) {
				
			 }
			  System.out.println(String.format("%f", c.similarity(files1[i], files2[0]))
						+ "," + (String.format("%f", c.similarity(files1[i], files2[1])))
						+ "," + (String.format("%f", c.similarity(files1[i], files2[2])))
						+ "," + (String.format("%f", c.similarity(files1[i], files2[3])))
						+ "," + (String.format("%f", c.similarity(files1[i], files2[4]))));
			 }
		/*
		 * A for loop is designed starting from 0 to 100. This piece of code appends to the CSV file,
		 * creating 100 rows (1.txt to 100.txt). It also creates 5 columns for a.txt to e.txt.
		 */
		for(int k = 0; k<100; k++) {
			sb.append(String.format("%f", c.similarity(files1[k], files2[0])));
			sb.append(",");
			sb.append(String.format("%f", c.similarity(files1[k], files2[1])));
			sb.append(",");
			sb.append(String.format("%f", c.similarity(files1[k], files2[2])));
			sb.append(",");
			sb.append(String.format("%f", c.similarity(files1[k], files2[3])));
			sb.append(",");
			sb.append(String.format("%f", c.similarity(files1[k], files2[2])));
			sb.append("\r");
		}
			pw.write(sb.toString());
			pw.close();					//Close the PrintWriter
		}
	}
}