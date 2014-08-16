package uva.collections;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.TreeSet;

public class AndysFirstDictionary {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("src/tests/AndysFirstDictionary.in"));
		//Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		TreeSet<String> dict = new TreeSet<>();
		while(sc.hasNextLine()){
			String str = sc.nextLine().toLowerCase();
			String[] words = str.replaceAll("[^a-z]", " ").replaceAll(" +", " ").split(" ");
			
			for(int i = 0; i < words.length; i++)
				if(words[i].trim().matches("[a-z]+")) dict.add(words[i]);
			
		}
		
		for(String str:dict){
			out.println(str);
		}
		
		out.close();
		sc.close();

	}

}
