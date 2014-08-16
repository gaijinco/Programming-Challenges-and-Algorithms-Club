package uva.collections;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Stack;

public class ParenthesesBalance {

	public static void main(String[] args) throws FileNotFoundException {
		//Scanner sc = new Scanner(new File("src/tests/ParenthesesBalance.in"));
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int T = sc.nextInt();
		sc.nextLine();
		for(int i = 0; i < T; i++) {
			String str = sc.nextLine();
			Stack<Character> st = new Stack<Character>();
			
			for(int j = 0; j < str.length(); j++) {
				if(str.charAt(j) == '[' || str.charAt(j) == '('){
					st.push(str.charAt(j));
				}
				else{
					//If empty, there is an ( remaining
					if( st.empty() ){
						st.push('*');
						break; 
					}
					boolean same = ( st.peek() == '[' && str.charAt(j) == ']' ) ||  ( st.peek() == '(' && str.charAt(j) == ')' );
					if(!same ) 	break;
					st.pop();
				}
			}
			
			if(st.isEmpty()) out.println("Yes");
			else out.println("No");			
		}
		out.close();
		sc.close();
	}

}


