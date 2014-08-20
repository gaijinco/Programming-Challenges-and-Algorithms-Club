// UVA 494
// http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=435

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new File("files/input.txt"));
		
		
		while(sc.hasNextLine()){
			String line = sc.nextLine();
			String[] words = line.split("[^a-zA-Z]+");
			
			int count = words.length;
			for (int i=0; i<words.length; i++){
				if (words[i].length()==0){
					count--;
				}
			}
			
			System.out.println(count);
		}
	
		sc.close();
	}
} 

// Expected Output:
// 2
// 7
// 10
// 9