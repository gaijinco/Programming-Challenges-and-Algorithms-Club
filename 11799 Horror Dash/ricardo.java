package uva.adhoc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HorrorDash {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		//Scanner sc = new Scanner(new File("src/tests/HorrorDash.in"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int i = 0; i < T; i++) {
			int N = sc.nextInt();
			//Este es el clasico algoritmo para encontrar el numero mayor.
			int highest = Integer.MIN_VALUE;
			for(int j = 0; j < N; j++){
				int c = sc.nextInt();
				if(c > highest){
					highest = c;
				}
			}
			
			System.out.printf("Case %d: %d\n", (i + 1), highest);
		}//for( int i = 0;

	}

}
