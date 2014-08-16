package uva.collections;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DNASorting {


	public static void main(String[] args) throws FileNotFoundException {
		long time = System.currentTimeMillis();
	
		Scanner sc = new Scanner(new File("src/tests/DNASorting.in"));
		//Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int T = sc.nextInt();
		
		for(int i =0; i < T; i++) {
			ArrayList<DNA> list = new ArrayList<DNA>();
			int n = sc.nextInt(); //length of the strings
			int m = sc.nextInt(); //num of strings
			
			for(int j = 0; j < m; j++) {				
				String str = sc.next();
				list.add(new DNA(str));
			}
			
			Collections.sort(list);
			
			for(DNA str : list) {
				out.println(str);
			}
			if(i < T - 1) out.println();
		}
		
		out.println(System.currentTimeMillis() - time );
		
		out.close();
		
		
		
		
	}
	
	static class DNA implements Comparable<DNA>{
		String str;
		int rank;
		static int[] lettersIndex= new int['T' + 1];
		static char[] letters = {'A','C','G','T'}; 
		
		public DNA(String str){
			this.str = str;
			lettersIndex['A'] = 0;
			lettersIndex['C'] = 1;
			lettersIndex['G'] = 2;
			lettersIndex['T'] = 3;	
			
			this.rank = rank();
			
					
		}

		@Override
		public int compareTo(DNA o) {
			DNA other = (DNA) o;
			// TODO Auto-generated method stub
			if( this.rank < other.rank ) return - 1;
			if( this.rank > other.rank ) return 1;
			return 0;
		}
		
		public String toString(){
			return this.str;
		}
		
		int rank(){
			int[] count = new int['T' + 1];
			int outOfOrder = 0;
			
			//count letters
			for(int c = 0; c < str.length(); c++) {
				count[str.charAt(c)]++;
			}
			
			//for(int i=0; i < 4; i++) System.out.printf("%s, %d%n",letters[i], count[letters[i]]);
			
			//count out of order
			for(int c =0; c < str.length(); c++) {
				
				char current = str.charAt(c);
				int letterIndex = lettersIndex[current] - 1;

				for(; letterIndex >= 0; letterIndex--)
					outOfOrder += count[ letters[letterIndex] ]; 
				
				count[current]--;
			}
			
			return outOfOrder;
		}
	}
	
	
}
