package uva.collections;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Argentina {
	//Solucion utilizando multiples sort estables, complejidad O(n*log(n))
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("src/tests/Argentina.in"));
		//Scanner sc = new Scanner(System.in);
		
		PrintWriter out = new PrintWriter(System.out);
		int T = sc.nextInt();
		
		
		for(int i = 0; i < T; i++) {
			ArrayList<Player> players = new ArrayList<Player>();
			
			for(int j = 0; j < 10; j++)
				players.add(new Player(sc.next(), sc.nextInt(), sc.nextInt()) );
			
			
			Collections.sort(players,new Comparator<Player>(){
				@Override
				public int compare(Player p1, Player p2) {
					return p1.name.compareTo(p2.name);
				} });
			
			Collections.sort(players,new Comparator<Player>(){
				@Override
				public int compare(Player p1, Player p2) {
					return p1.deffense - p2.deffense;
				} });
			
			Collections.sort(players,new Comparator<Player>(){
				@Override
				public int compare(Player p1, Player p2) {
					return p2.atack - p1.atack;
				} });
			
			out.printf("Case %d:%n", i + 1);
			
			String[] pNames = new String[5]; 
			for(int j = 0; j < 5; j++){
				pNames[j] = players.get(j).name;
			}
			Arrays.sort(pNames);
			print(pNames, out);
			 
			for(int j = 0; j < 5; j++){
				pNames[j] = players.get(5 + j).name;
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
	
	static void print(List p){
		for(int i = 0; i < p.size(); i++ )
			System.out.println(p.get(i));
		
		System.out.println();
	}
	
	static class Player{
		String name;
		int atack;
		int deffense;
		public Player(String name, int atack,int deffense) {
			this.name = name;
			this.atack = atack;
			this.deffense = deffense;
		}
		public String toString(){
			return String.format("%s %d %d", this.name, this.atack, this.deffense);
		}
		
	}
}
