package uva.collections;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class TheDragonOfLoowater {
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("src/tests/TheDragonOfLoowater.in"));
		//Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int[] dragons = new int[20002];
		int[] knights = new int[20002];
		
		while(true){
			int numDragons = sc.nextInt();
			int numKnights = sc.nextInt();
			
			if(numKnights == 0 && numDragons == 0) break;
			
			
			
			int smallestDragon = Integer.MAX_VALUE;
			int biggestDragon = Integer.MIN_VALUE;
			for(int i =0; i < numDragons; i++){
				int dg = sc.nextInt();
				if(dg < smallestDragon) smallestDragon = dg;
				if(dg > biggestDragon) biggestDragon = dg;
				dragons[i] = dg;
			}
			Arrays.sort(dragons, 0, numDragons);
			int kSize = 0;
			for(int i =0; i < numKnights; i++){
				int kH = sc.nextInt(); //knight Height
				if(kH < smallestDragon) continue;
				knights[kSize] = kH;
				kSize++;
			}
			numKnights = kSize;
			Arrays.sort(knights,0, numKnights);//Sort to apply ceiling binnary search
			
			if(numKnights == 0) {
				out.println("Loowater is doomed!");
				continue;
			}
			
			//If biggest knight is small than biggest Dragon
			if(knights[numKnights - 1] < biggestDragon){
				out.println("Loowater is doomed!");
				continue;
			}
						
			if(numKnights < numDragons){
				out.println("Loowater is doomed!");
				continue;
			}

			long gold = 0;
			boolean ok = true;
			//looking first knight equal or greater or equal than the head of the dragon
			
			
			//From biggest dragon
			int lastKnight = 0;
			for(int i = 0; i < numDragons; i++){
				//getting better knight index
				
				int ki = -1;				
				for(int j = lastKnight; j < numKnights; j++){
					
					if( knights[j] >= dragons[i] ){
						ki = j;
						lastKnight = j + 1;
						break;
					}
					
				}
				
				
				if(ki == -1){
					ok = false;
					break;
				}
				
				
				gold += knights[ki];
				
				//removing knight from search
				
				
			}
			
			if(ok) out.println(gold);
			else out.println("Loowater is doomed!");
			
		}
		out.close();
		sc.close();

	}

}
