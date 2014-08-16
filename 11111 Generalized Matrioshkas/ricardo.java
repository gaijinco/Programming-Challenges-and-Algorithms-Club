package uva.collections;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Stack;

public class GeneralizedMatrioshkas {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner sc = new Scanner(new File("src/tests/GeneralizedMatrioshkas.in"));
		//Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		
		while(sc.hasNextLine()){
			
			Scanner line = new Scanner( sc.nextLine() );
			
			Stack<Long> st = new Stack<Long>();
			Stack<Long> childrenSum = new Stack<Long>();
			
			int c = 0;
			
			while(line.hasNextLong()){
				long num = line.nextLong();
				
				//If several level-0 parents like: -9 ... 9 -
				if(c > 0 && st.empty()){
					st.push(0l); //adding entry and breaking to cause error
					break; 
				}
				
				if(num < 0 ) {
					//sum to top and compare
					if(!childrenSum.empty()){
						long sum = childrenSum.pop();
						childrenSum.push(sum + num*-1 );
						//Wrong Sum of childrens
						if(childrenSum.peek() >= st.peek()*-1 ){
							st.push(0l); //adding entry and breaking to cause error
							break;
						}
					}
					
					st.push(num);
					
					//initialize internal sum
					childrenSum.push(0l);
					
				}else{
					
					//Closing without opening
					if( st.empty() ){  
						st.push(0l); //adding entry and breaking to cause error
						break;
					}
					
					//Different item closing/Bad nesting
					if( num != st.peek()*-1 ){
						st.push(0l); //adding entry and breaking to cause error
						break;
					}
					
					//Remove internal sum
					childrenSum.pop();					
					st.pop();
					
				}
				c++;
				
			}
			if(st.empty())  out.println(":-) Matrioshka!");
			else out.println(":-( Try again.");
			
			line.close();
		}
		
		out.close();
		sc.close();

	}
}
