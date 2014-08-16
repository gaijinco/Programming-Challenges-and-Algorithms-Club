package uva.collections;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class Argentina2 {
	
	//Solucion utilizando un solo Comparte to selectivo
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("src/tests/Argentina.in"));
		//Scanner sc = new Scanner(System.in);
		
		PrintWriter out = new PrintWriter(System.out);
		
		int T = sc.nextInt();
		
		
		for(int i = 0; i < T; i++) {
			ArrayList<Player> players = new ArrayList<Player>();
			
			for(int j = 0; j < 10; j++)
				players.add(new Player(sc.next(), sc.nextInt(), sc.nextInt()) );
			
			Collections.sort(players);
			out.printf("Case %d:%n", i + 1);
			
			//Local sort and preparing for output
			String[] pNames = new String[5]; 
			for(int j = 0; j < 5; j++){
				pNames[j] = players.get(j).toString();
			}
			Arrays.sort(pNames);
			print(pNames, out);
			 
			for(int j = 0; j < 5; j++){
				pNames[j] = players.get(5 + j).toString();
			}
			Arrays.sort(pNames);
			
			print(pNames, out);
		}
		
		out.close();
		sc.close();
		
	}
	
	static void print(String[] names, PrintWriter out){
		
		out.print("(");
		for(int i =0; i < names.length; i++){
			if(i > 0)
				out.print(", ");
			out.print(names[i]);
		}
		out.println(")");	
		
	}
	
	static class Player implements Comparable<Player>{
		String name;
		int deffense;
		int atack;
		
		public Player(String name, int atack,int deffense) {
			this.name = name;
			this.atack = atack;
			this.deffense = deffense;
		}
		public String toString(){
			return String.format("%s %d %d", this.name, this.atack, this.deffense);
		}
		@Override
		public int compareTo(Player o) {
			int atackC = atack - o.atack;
			return atackC;
			/* if(atackC != 0)
				 return atackC;
			
			int deffenseC = this.deffense - o.deffense;			
			if(deffenseC != 0)
				return deffenseC;
			
			return name.compareTo(o.name);*/
		}
		
		
	}
	
	
}
