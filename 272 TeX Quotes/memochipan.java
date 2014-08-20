// UVA 272
// http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=208

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new File("files/input.txt"));
		boolean q = true;
		
		while(sc.hasNextLine()){
			char[] s = sc.nextLine().toCharArray();
			String chars;
			for (int i=0; i<s.length; i++){
				if (s[i]=='"'){
					if (q) {
						chars = "``";
					} else {
						chars = "''";
					}
					q = !q;
				} else {
					chars = String.valueOf(s[i]);
				}
				System.out.print(chars);
			}
			System.out.println();
		}
		
		sc.close();
	}
}

// Expected Output:
// ``To be or not to be,'' quoth the Bard, ``that
// is the question''.
// The programming contestant replied: ``I must disagree.
// To `C' or not to `C', that is The Question!''