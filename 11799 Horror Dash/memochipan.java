// UVA 11799
// http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=2899

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new File("files/input.txt"));
		
		int tests = Integer.parseInt(sc.nextLine());
				
		for (int c=1; c<=tests; c++){
			
			String line = sc.nextLine();
			String[] test = line.split("\\s");
			
			int students = Integer.parseInt(test[0]);
			int max = 0;
			
			for (int i=1; i<=students; i++){ 
				int val = Integer.parseInt(test[i]);
				if (val > max){
					max = val;
				}
			}
			
			System.out.println("Case "+c+": "+max);
		}
		
		sc.close();
	}
}

// Expected Output:
// Case 1: 9
// Case 2: 2